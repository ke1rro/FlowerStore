package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Store {
    private List<FlowerBucket> flowerBuckets;

    public Store() {
        flowerBuckets = new LinkedList<FlowerBucket>();
    }

    public List<FlowerBucket> search(FlowerSpecs searchSpecs) {
        List<FlowerBucket> matchingBuckets = new ArrayList<FlowerBucket>();

        for (FlowerBucket bucket : flowerBuckets) {
            if (bucketMatchesSpecs(bucket, searchSpecs)) {
                matchingBuckets.add(bucket);
            }
        }

        return matchingBuckets;
    }

    public void addFlowerBucket(FlowerBucket bucket) {
        if (bucket != null) {
            flowerBuckets.add(bucket);
        }
    }

    public boolean removeFlowerBucket(FlowerBucket bucket) {
        return flowerBuckets.remove(bucket);
    }

    public int getBucketCount() {
        return flowerBuckets.size();
    }

    public List<FlowerBucket> getAllFlowerBuckets() {
        return new ArrayList<>(flowerBuckets);
    }

    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (FlowerBucket bucket : flowerBuckets) {
            totalValue += bucket.getPrice();
        }
        return totalValue;
    }

    public boolean isEmpty() {
        return flowerBuckets.isEmpty();
    }

    public void clearInventory() {
        flowerBuckets.clear();
    }

    private boolean bucketMatchesSpecs(FlowerBucket bucket, FlowerSpecs specs) {
        if (bucket == null || specs == null) {
            return false;
        }
        return bucket.containsFlowerWithSpecs(specs);
    }

    @Override
    public String toString() {
        return "Store [buckets=" + flowerBuckets.size() +
                ", total_value=" + getTotalInventoryValue() + "]";
    }
}
