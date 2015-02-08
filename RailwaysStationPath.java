import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class RailwaysStationPath {

	public List<String> railwayStations;
	
	public Map<Integer, Long> shortestDistances;
	
	public Long[][] pathLength;
	
	public void init(int stationsCount, int edgesCount){
		this.pathLength = new Long[stationsCount][stationsCount];
		
		for(int i=0; i<stationsCount; i++){
			for (int j = 0; j < stationsCount; j++) {
				this.pathLength[i][j] = i==j?0L:-1L;
			}
		}

	}
	
	public void printPaths(){
		for(int i=0; i<this.railwayStations.size(); i++){
			for (int j = 0; j < this.railwayStations.size(); j++) {
				System.out.print(this.pathLength[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	
	public Long getShortestPathDistance(int source, int destination){
		this.shortestDistances = new HashMap<Integer, Long>();		
		Map<Integer, Long> tmpShortestDistance = new HashMap<Integer, Long>();
		
		this.shortestDistances.put(source, 0L);
		
		//find adjacent Nodes of source
		//set shortest distance of nodes in that
		//pull out min to shortestDistance
		
		while(!shortestDistances.containsKey(destination)){
			for (int dest = 0; dest < pathLength.length; dest++) {
				if(source!=dest && pathLength[source][dest]!=-1){
					
					Long currentPathDistance = (shortestDistances.get(source)+pathLength[source][dest]);
					
					if(!tmpShortestDistance.containsKey(dest) && !tmpShortestDistance.containsKey(dest)){
						tmpShortestDistance.put(dest,currentPathDistance);
					}
					
					Long currentDistance = tmpShortestDistance.get(dest);
					Long minDistance = currentDistance < currentPathDistance ? currentDistance: currentPathDistance;
					
					tmpShortestDistance.put(dest, minDistance);
				}
			}
			
			int smallestPath = getSmallestPathNode(tmpShortestDistance);
			shortestDistances.put(smallestPath, tmpShortestDistance.get(smallestPath));
			tmpShortestDistance.remove(smallestPath);
			
			source= smallestPath;
		}
		
		
		return this.shortestDistances.get(destination);
	}
	
	public int getSmallestPathNode(Map<Integer, Long> tmpShortestDistance){
		int smallest;
		
		Iterator<Entry<Integer, Long>> itr = tmpShortestDistance.entrySet().iterator();
		smallest = itr.next().getKey();
		
		while(itr.hasNext()){
			Entry<Integer, Long> currentNode = itr.next();
			smallest = tmpShortestDistance.get(smallest)<currentNode.getValue()?smallest:currentNode.getKey();
		}
		
		return smallest;
	}
	
	public static void main(String[] args) {

		Scanner br = new Scanner(System.in);
		int stationsCount = br.nextInt();
		int edgesCount = br.nextInt();
		
		RailwaysStationPath obj = new RailwaysStationPath();
		obj.init(stationsCount, edgesCount);
		
		br.nextLine();
		
		String stations  = br.nextLine();
		obj.railwayStations = Arrays.asList(stations.split(" "));
		
		while(edgesCount>0){
			
			String edgeDetails = br.nextLine();
			String[] tmp = edgeDetails.split(" ");
			
			int rs1 = obj.railwayStations.indexOf(tmp[0]);
			int rs2 = obj.railwayStations.indexOf(tmp[1]);
			Long length = Long.valueOf(tmp[2]);
			
			obj.pathLength[rs1][rs2] = length;
			obj.pathLength[rs2][rs1] = length;
			
			edgesCount--;
		}
		
		int queryCount = br.nextInt();
		br.nextLine();
		
		while(queryCount>0){
			
			String query = br.nextLine();
			
			String[] tmp = query.split(" ");
			
			int source = obj.railwayStations.indexOf(tmp[0]);
			int destination = obj.railwayStations.indexOf(tmp[1]);
			
			System.out.println(obj.getShortestPathDistance(source, destination));			
			
			queryCount--;
		}
		
	}
}
