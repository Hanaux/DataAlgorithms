package week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EightPuzzle_Astar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] board;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static HashMap<Integer,Integer> visitMap = new HashMap<>(); 
	static HashSet<Integer> impossibleSet =  new HashSet<Integer>();
	static HashMap<Integer,Integer> pNode=new HashMap<>();
	static HashMap<Integer,Integer> fSave=new HashMap<>();
	
    static String uTarget="123456789";

	static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2){
			if(o1.f==o2.f) return Integer.compare(o1.g,o2.g);
			return Integer.compare(o1.f,o2.f);
		}
	});
	static class Node{
		String board;
		int g;
		int f;
		public Node(String data,int g,int f) {
			this.board = data;
			this.g=g;
			this.f=f;
		}
	}

	static String Out1="";

	public static void main(String[] args) throws NumberFormatException, IOException {
		String str="";
		char cOut=' ';

        setData();
        astarAlgorithm();
        if(visitMap.containsKey(Integer.parseInt(uTarget))) {

            int fValue=Integer.parseInt(uTarget);
            int fCount=(int)visitMap.get(Integer.parseInt(uTarget));

            String [][] spNode = new String[fCount][2];
            String [][] sfSave = new String[fCount][2];

            int sPosition=0;

            for(int i=0;i<fCount;i++) {
                sPosition=fCount-i-1;
                spNode[sPosition][0]=String.valueOf(i);
                spNode[sPosition][1]=String.valueOf(pNode.get(fValue));
                sfSave[sPosition][0]=String.valueOf(i);
                sfSave[sPosition][1]=String.valueOf(fSave.get(fValue));
                fValue=(int)pNode.get(fValue);
            }
            
            str="";

            for(int i=0;i<fCount;i++) {
                Out1+="Node #"+(i+1)+"\n";
                for(int j=0;j<9;j++) {
                    cOut=spNode[i][1].charAt(j);
                    if(cOut=='9') cOut=' ';
                    Out1+=cOut+" ";
                    if(j%3==2 && j!=8) Out1+="\n";
                }
                str=" h = "+sfSave[i][1];
                Out1+=str+"\n\n";
            }

            Out1+="Node #"+(fCount+1)+"\n";

            for(int j=0;j<9;j++) {
                cOut=uTarget.charAt(j);
                if(cOut=='9') cOut=' ';
                Out1+=cOut+" ";
                if(j%3==2 && j!=8) Out1+="\n";
            }
            Out1+="\n\n";
        } else {
            for(Integer key : visitMap.keySet()) impossibleSet.add(key);
            bw.write("Impossible"+"\n");
        }
		bw.write("\n"+Out1+"\n");
		bw.flush();
		bw.close();
	}
	private static void astarAlgorithm(){
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			String numberBoard = currentNode.board;
			int sharpIndex = numberBoard.indexOf("9");
			int cr = sharpIndex/3;
			int cc = sharpIndex%3;
			
			if(impossibleSet.contains(Integer.parseInt(numberBoard))) return;
			
			String data = "";

			for(int dir=0;dir<4;dir++){
				int nr = cr+dr[dir];
				int nc = cc+dc[dir];
				if(rangeCheck(nr,nc)){
					StringBuilder next = new StringBuilder(numberBoard);
					next = swap(cr,cc,nr,nc,next);
					data = next.toString();
					
					if(visitMap.containsKey(Integer.parseInt(data))) continue; 
					else {
						int g = currentNode.g;
						int heuristic = getHeuristicValue(data); 
						int f = g+heuristic; 
						pq.add(new Node(data,g+1,f));
						visitMap.put(Integer.parseInt(data),g+1);

						pNode.put(Integer.parseInt(data),Integer.parseInt(numberBoard));
						fSave.put(Integer.parseInt(data),heuristic);
					}
				}
			}
			
			if(visitMap.containsKey(Integer.parseInt(uTarget))) return; 
		}
	}
	private static int getHeuristicValue(String data){
		int count = 0;
		for(int i=0;i<data.length();i++) {
			if(uTarget.charAt(i)!=data.charAt(i)) count++;
		}
		return count;
	}
	private static StringBuilder swap(int cr, int cc, int nr, int nc, StringBuilder next) {
		int currentRC = cr*3+cc;
		int nextRC = nr*3+nc;
		char temp = next.charAt(currentRC);
		next.setCharAt(currentRC,next.charAt(nextRC));
		next.setCharAt(nextRC,temp);
		return next;
	}
	private static boolean rangeCheck(int nr, int nc){
		if(nr>=0 && nr<3 && nc>=0 && nc<3) return true;
		return false;
	}
	private static void setData() throws IOException {
		board = new char[3][3];
		visitMap.clear();
		pq.clear();
		String boardStr="";
		for(int row=0;row<3;row++) {
			board[row] = br.readLine().toCharArray();
			for(int col=0;col<3;col++) {
				if(board[row][col]=='#') board[row][col] = '9';
				boardStr+=board[row][col];
			}
		}
		pq.add(new Node(boardStr,0,0));
		visitMap.put(Integer.parseInt(boardStr),0);
	}
}