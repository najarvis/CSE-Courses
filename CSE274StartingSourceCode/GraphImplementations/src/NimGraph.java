import java.util.*;

public class NimGraph {
	private Set<NimBoard> states;
	private Map<NimBoard, Set<NimBoard>> adjList;
	
	public NimGraph() {		
		states = new HashSet<NimBoard>();
		adjList = new HashMap<NimBoard, Set<NimBoard>>();
		
		NimBoard origState = new NimBoard();
		Queue<NimBoard> toProcess = new LinkedList<>();
		toProcess.add(origState);
		
		while (!toProcess.isEmpty()) {
			NimBoard brd = toProcess.remove();
			if (!adjList.containsKey(brd)) {
				Set<NimBoard> successors = brd.getSuccessors();
				adjList.put(brd, successors);
				toProcess.addAll(successors);
				states.addAll(successors);
			}
		}
	}
	public Set<NimBoard> getSuccessors(NimBoard brd) {
		return adjList.get(brd);
	}
}
