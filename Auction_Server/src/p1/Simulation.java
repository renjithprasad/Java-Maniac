package p1;


/**
 * Class provided for ease of test. This will not be used in the project 
 * evaluation, so feel free to modify it as you like.
 */ 
public class Simulation
{
	static final String PASS = "PASS";
    static final String FAIL = "**FAIL";
	static int nrSellers = 50;
    static int nrBidders = 20;
    
    static Thread[] sellerThreads = new Thread[nrSellers];
    static Thread[] bidderThreads = new Thread[nrBidders];
    static Seller[] sellers = new Seller[nrSellers];
    static Bidder[] bidders = new Bidder[nrBidders];
    static AuctionServer server;
    
	public static void main(String[] args)
    {                
		server = AuctionServer.getInstance(); 
        
		//System.out.print("CASE 1 " + case1() + ": Sellers shall be punished for presenting bids over $100. Three bids over $100 should disqualify the seller from bidding for the rest of the bidding session  \n");
		//System.out.print("CASE 2 " + case2() + ": New bids must at least match the opening bid if no one else has bid yet \n");
		//System.out.print("CASE 3 " + case3() + ": New bids must exceed the current highest bid if other bids have already been placed on the item \n");
		//System.out.print("CASE 4 " + case4() + ": Once a Bidder holds the current highest bid for an item they will only be allowed to successfully place another bid if another Bidder overtakes them for the current highest bid. \n");
		System.out.print("CASE 5 " + case5() + ": All prices will be listed in whole dollars only OR All items will open with non-negative opening prices \n");
    }
	
	private static String case5() {

        int listingID1 = server.submitItem("Test seller 4", "test item 8", -10, 100);    //-10 is not a whole number
        int listingID2 = server.submitItem("Test seller 4", "test item 9", 0, 100);      //0 is a whole number

        if ((listingID1 == -1) && (listingID2 != -1))
            return PASS;

        return FAIL;
    }    
	/*private static String case1() {
            //lowestBiddingPrice should not exceed 100
            int listingID1 = server.submitItem("Test seller 1", "test item 1", 100, 100);                  //lowestBiddingPrice can be equal to 100
            int listingID2 = server.submitItem("Test seller 1", "test item 2", 105, 100);                  //should be rejected by server
            int listingID3 = server.submitItem("Test seller 1", "test item 2", 125, 100);                  //should be rejected by server
            int listingID4 = server.submitItem("Test seller 1", "test item 3", 230, 100);                  //should be rejected by server
            int listingID5 = server.submitItem("Test seller 1", "test item 4", 10, 100);                   //should be rejected by server as seller is disqualified
            if ((listingID1 != -1) && (listingID2 == -1) && (listingID3 == -1) && (listingID4 == -1) && (listingID5 != -1)){
                return PASS;
            } else {
            return FAIL;
            }
        }*/

	/*private static String case4() {

        boolean test1 = false, test2 = false;

        int listingID = server.submitItem("Test seller 3", "test item 7", 70, 100);
        if (listingID != -1) {
            if (server.submitBid("Test bidder 4", listingID, 80))
                if (!server.submitBid("Test bidder 4", listingID, 85))           //bidder 4 should not be allowed to place a bid until some other bidder take over the highest bid
                    test1 = true;


            if (server.submitBid("Test bidder 5", listingID, 90))
                if (server.submitBid("Test bidder 4", listingID, 95))           //bidder 4 should be allowed to place a bid
                    test2 = true;


            if (test1 && test2)
                return PASS;
        }
        return FAIL;
    }*/
	/*private static String case2() {
    boolean test1 = false, test2 = false;

    int listingID = server.submitItem("Test seller 2", "test item 5", 100, 100);
    System.out.println(listingID);
    if (listingID != -1) {
        if (!server.submitBid("Test bidder 1", listingID, 80))                              //bidding amount should not be less than listing amount
            test1 = true;
        System.out.println(test1);

        if (server.submitBid("Test bidder 1", listingID, 100))                              //bidding amount can be equal to listing amount
            test2 = true;
        System.out.println(test2);

        if (test1 && test2)
            return PASS;
    }
    return FAIL;
}*/
/*	private static String case3() {
        int listingID = server.submitItem("Test seller 3", "test item 6", 70, 100);
        if (listingID != -1) {
            if (server.submitBid("Test bidder 2", listingID, 100))
                if (!server.submitBid("Test bidder 3", listingID, 60))           //Bidder 3 should not be allowed to place a bid <= the current highest bid i.e 100
                    return PASS;
        }
        return FAIL;
    }
    */
}


        
       /* // Start the sellers
        for (int i=0; i<nrSellers; ++i)
        {
            sellers[i] = new Seller(
            		AuctionServer.getInstance(), 
            		"Seller"+i, 
            		100, 50, i
            );
            sellerThreads[i] = new Thread(sellers[i]);
            sellerThreads[i].start();
        }
        
        // Start the buyers
        for (int i=0; i<nrBidders; ++i)
        {
            bidders[i] = new Bidder(
            		AuctionServer.getInstance(), 
            		"Buyer"+i, 
            		1000, 20, 150, i
            );
            bidderThreads[i] = new Thread(bidders[i]);
            bidderThreads[i].start();
        }
        
        // Join on the sellers
        for (int i=0; i<nrSellers; ++i)
        {
            try
            {
                sellerThreads[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        // Join on the bidders
        for (int i=0; i<nrBidders; ++i)
        {
            try
            {
            	bidderThreads[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        // TODO: Add code as needed to debug
*/        