package models;

import java.util.ArrayList;

public class Router1 {
	
	private ArrayList<ArrayList<Integer>> costs;
	private Packet packet;
	
	public void rinit1(){
		int i = 0;
		costs = new ArrayList<ArrayList<Integer>>();
		packet = new Packet(0, 0);
		
		
		//tabla de dimensiones
		for(i=0; i<4; i++){
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(999);
			a.add(999);
			a.add(999);
			a.add(999);
			costs.add(a);
		}
		
		costs.get(0).set(0, 1);
		costs.get(2).set(2, 1);
		
		
		for(i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(packet.getMincost().get(i) > costs.get(i).get(j)){
					packet.getMincost().add(i, costs.get(i).get(j));
				}
			}
		}
		
		packet.setSourceId(1);
		packet.setDestId(0);
		//Enviar a layer2 usando tolayer2
		//toLayer2(packet);
		
		packet.setSourceId(1);
		packet.setDestId(2);
		//Enviar a layer2 usando tolayer2
		//toLayer2(packet);
		
	}
	
	public void rupdate1(Packet rcvdpk) {
		//float clocktime;
				packet = new Packet(0, 0);
				//ArrayList<Integer> temp = new ArrayList<Integer>(4);
				boolean change = false;
				int i = 0, j = 0;
				
				for(i=0;i<4;++i){
					if(costs.get(i).get(rcvdpk.getSourceId()) > rcvdpk.getMincost().get(i) + costs.get(rcvdpk.getSourceId()).get(rcvdpk.getSourceId())){
						costs.get(i).add(rcvdpk.getSourceId(), rcvdpk.getMincost().get(i) + costs.get(rcvdpk.getSourceId()).get(rcvdpk.getSourceId()));  
						change = true;
					}
				}
				
				if(change){
					for(i=0;i<4;i++){
						for(j=0;j<4;j++){
							if(packet.getMincost().get(i) > costs.get(i).get(j)){
								packet.getMincost().add(i, costs.get(i).get(j));
							}
						}
					}
					
					packet.setSourceId(1);
					packet.setDestId(0);
					//Enviar a layer2 usando tolayer2
					//toLayer2(packet);
					
					packet.setSourceId(1);
					packet.setDestId(2);
					//Enviar a layer2 usando tolayer2
					//toLayer2(packet);
							
				}		
			
	}
	
	public ArrayList<ArrayList<Integer>> getCosts() {
		return costs;
	}

	public void setCosts(ArrayList<ArrayList<Integer>> costs) {
		this.costs = costs;
	}
	
	

}
