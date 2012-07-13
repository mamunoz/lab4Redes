#include <stdio.h>


extern struct rtpkt {
  int sourceid;       /* id of sending router sending this pkt */
  int destid;         /* id of router to which pkt being sent
                         (must be an immediate neighbor) */
  int mincost[4];    /* min cost to node 0 ... 3 */
  };

struct distance_table
{
  int costs[4][4];
} dt0;


extern int TRACE;
extern int YES;
extern int NO;

struct rtpkt packet;
/* students to write the following two routines, and maybe some others */

void rtinit0()
{

	packet.mincost[0] = 999;
	packet.mincost[1] = 999;
	packet.mincost[2] = 999;
	packet.mincost[3] = 999;

	
        printf("inside rinit0 function");
	
	int i;
	int j;

	//sets all distances to node i from node j to infinity
	for(i=0;i<4;i++)
	{
		for(j=0; j<4; j++)
		{
			dt0.costs[i][j]= 999;

		}
	}
        //sets the direct distances from node 0 to nodes 1,2,3 according 
        //to the lab
	dt0.costs[1][1]=1;
	dt0.costs[2][2]=3;
	dt0.costs[3][3]=7;

	//for each distance through node i from node j, check if minimum cost is        //smaller than infinity, if so set it to the minimum cost, if not keep i        t at infinity
	for(i=0;i<4;i++)
	{
		for(j=0; j<4; j++)
		{
			if(packet.mincost[i] > dt0.costs[i][j])
				packet.mincost[i] = dt0.costs[i][j];
		}
	}
        //set packet's sourceid to 0, since this code is for node 0
        //calling function tolayer2 in order for information to be transferred
        //from network layer to layer 2(data link layer)
	packet.sourceid = 0;
	packet.destid = 1;
	tolayer2(packet);  //simulate layer 2 with the given source&destination

	packet.sourceid = 0;
	packet.destid = 2;
	tolayer2(packet);  //simulate data link layer

	packet.sourceid = 0;
	packet.destid = 3;
	tolayer2(packet);  //simulate data link layer

	printdt0(&dt0);
	printf("done with rtinit0\n");
}

/*updates the distance vector table in case of changes*/
void rtupdate0(rcvdpkt)
  struct rtpkt *rcvdpkt;
{
	//setting all minimum costs to nodes 0,1,2,3 to infinity
        packet.mincost[0] = 999;
	packet.mincost[1] = 999;
	packet.mincost[2] = 999;
	packet.mincost[3] = 999;
	
	printf("inside rtupdate0\n");

	//prints out updates of packets sent to sourceid = node 0
	//with respect to time
	extern float clocktime; //from prog3.c
	printf("rtupdate0: %f\n sender: %d\n", clocktime, rcvdpkt->sourceid);
	printdt0(&dt0);

	
	int temp[4];
	int change = 0;
	int i;
	int j;
	for(i = 0; i < 4; ++i)
	{
		//checks for updates to see if any cost should be changed
               // this is done by switching the value change from 0 to 1
		if(dt0.costs[i][rcvdpkt->sourceid] > rcvdpkt->mincost[i] +  dt0.costs[rcvdpkt->sourceid][rcvdpkt->sourceid])
		{
			dt0.costs[i][rcvdpkt->sourceid] = rcvdpkt->mincost[i]  + dt0.costs[rcvdpkt->sourceid][rcvdpkt->sourceid]; 
			change = 1;
		}
	}
	//if the change has actually happened, update the table in accordance with the change, i.e. change minimum cost from 
        //infinity to the distance vector cost according to the diagram
	if(change)
	{
		for(i=0;i<4;i++)
		{
			for(j=0; j<4; j++)
			{
				if(packet.mincost[i]  > dt0.costs[i][j]) 
					packet.mincost[i] = dt0.costs[i][j];
			}
		}

		printf("finished updating distance table\n");


		
		//calls function tolayer2 to simulate data link layer after table has been updated 
		packet.sourceid = 0;
		packet.destid = 1;
		tolayer2(packet);

		packet.sourceid = 0;
		packet.destid = 2;
		tolayer2(packet);

		packet.sourceid = 0;
		packet.destid = 3;
		tolayer2(packet);
	}
	//pretty prints the distance vector diagram after update
	printdt0(&dt0);
}


printdt0(dtptr)
  struct distance_table *dtptr;
{
	

  printf("                via     \n");
  printf("   D0 |    1     2    3 \n");
  printf("  ----|-----------------\n");
  printf("     1|  %3d   %3d   %3d\n",dtptr->costs[1][1],
	 dtptr->costs[1][2],dtptr->costs[1][3]);
  printf("dest 2|  %3d   %3d   %3d\n",dtptr->costs[2][1],
	 dtptr->costs[2][2],dtptr->costs[2][3]);
  printf("     3|  %3d   %3d   %3d\n",dtptr->costs[3][1],
	 dtptr->costs[3][2],dtptr->costs[3][3]);
}

linkhandler0(linkid, newcost)
  int linkid, newcost;
{
/* called when cost from 0 to linkid changes from current value to newcost*/
/* You can leave this routine empty if you're an undergrad. If you want */
/* to use this routine, you'll need to change the value of the LINKCHANGE */
/* constant definition in prog3.c from 0 to 1 */


}