package preTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


class Cache{
	int capacity = 4;
	Integer[] valueWeight = new Integer[2];
	List<Double> scoreList = new ArrayList<Double>();
	HashMap<Integer, Double> scoreMap;
	HashMap<Integer, Integer> weightMap;
	HashMap<Integer, Integer> cacheMap;
	HashMap<Integer, Long> timeMap;
	
	public Cache(int capacity) {
		cacheMap = new HashMap<Integer, Integer>(capacity);
		timeMap = new HashMap<Integer, Long>(capacity);
		scoreMap = new HashMap<Integer, Double>(capacity);
		weightMap = new HashMap<Integer, Integer>(capacity);
	}
	
	public int get(int key) {
		for(int cacheKey: cacheMap.keySet()) {
			if (cacheKey == key) return cacheMap.get(cacheKey);
		}
		return -1;
	}
	
	public void put(int key, int value, int weight) {
		double score = 0;
		Boolean removeOne = true;
		long curtime = System.currentTimeMillis();
		double minscore = 0;

		if (cacheMap.containsKey(key)) {
			cacheMap.replace(key,value);
			weightMap.replace(key,weight);
			timeMap.replace(key,curtime);
		}
		
		else {
			if (cacheMap.size() != capacity) {
				cacheMap.put(key,value);
				weightMap.put(key,weight);
				timeMap.put(key,curtime);
			}
			
			else { 
				for(int timeKey: timeMap.keySet()) {
					if (curtime != timeMap.get(timeKey)) score = weightMap.get(timeKey) / Math.log(curtime - timeMap.get(timeKey));
					
					else score = weightMap.get(timeKey) / -100;
		            scoreMap.put(timeKey, score);
		            scoreList.add(score);
		          
		        }
				for(int scoreKey: scoreMap.keySet()) {
					minscore = Collections.min(scoreList);
		            if (scoreMap.get(scoreKey) == minscore && removeOne) {
		            	cacheMap.remove(scoreKey);
		            	removeOne = false;
		            }
		        }
				cacheMap.put(key,value);
				timeMap.put(key,curtime);
				weightMap.put(key,weight);
				scoreMap.clear();
			}
		}
	}
	
	public void display() {
		for(int cacheKey: cacheMap.keySet()) {
			System.out.print(cacheKey + " : "+cacheMap.get(cacheKey) + " " + weightMap.get(cacheKey) + "\n");
		}
		
	}
		
}

public class Q2{
	
	public static void main(String[] args) {
		int capacity = 4;
		Cache cache = new Cache(capacity);
        cache.put(1,17,4);
        cache.put(2,31,6);
        cache.put(3,11,1);
        cache.put(4,41,12);
        cache.put(5,1,12);
        cache.display();
        System.out.print(cache.get(3));
	}
	
}