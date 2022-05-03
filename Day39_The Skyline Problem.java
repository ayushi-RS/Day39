public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        //mark starting point and ending point
        for(int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]}); // to add starting point
            heights.add(new int[]{b[1], b[2]}); //to add end point
        }
        //here we have all the points that has been marked
        // now we sort as per the starting and ending point of the building marked in the heights list
        Collections.sort(heights, (a,b) -> {
           if(a[0]!=b[0]) {
               return a[0] - b[0];//sort as per starting and ending point when there is no 2 or more points that has similar point
           } else {
               return a[1] - b[1];//sort as per height when 2 or more points has same starting and ending point
           }
        });
        
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);
        int prevHeight = 0;
        List<List<Integer>> skyLines = new ArrayList<>();
        for(int[] h : heights) {
            if(h[1] < 0) {
                //here means we meet the new building so add into map or starting point of the building
                heightMap.put(-h[1], heightMap.getOrDefault(-h[1], 0) + 1);
                
            } else {
                //here means it has been reached to end of the building so remove it from the map
                if(heightMap.get(h[1]) == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], heightMap.get(h[1]) - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if(prevHeight != currHeight) {
                List<Integer> result = new ArrayList<>();
                result.add(h[0]);
                result.add(currHeight);
                skyLines.add(result);
                prevHeight = currHeight;
            }
        }
        return skyLines;
    }