package com.bratash.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        int i = 0;

        while(!cache.isEmpty() && i < cache.size()){
            System.out.println("write " + i + " line from cache");
            try {
                FileUtils.writeStringToFile(new File(fileName), cache.get(i).toString(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
