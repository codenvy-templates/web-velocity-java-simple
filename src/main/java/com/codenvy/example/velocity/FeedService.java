package com.codenvy.example.velocity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedService {
    private Map<Integer, Feed> storage = new HashMap<Integer, Feed>();

    public FeedService() {
        storage.put(1, new Feed(1, "Spring Tutorial"));
        storage.put(2, new Feed(2, "Velocity Tutorial"));
        storage.put(3, new Feed(3, "Java Tutorial"));
    }

    public Feed getFeedById(Integer id) {
        return storage.get(id);
    }

    public List<Feed> getFeeds() {
        List<Feed> list = new ArrayList<Feed>();
        list.addAll(storage.values());
        return list;
    }
}
