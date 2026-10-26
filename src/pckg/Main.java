/*
 * Ali Nofal
 * 
 * IDE : Eclipse
 * 
 */


package pckg;

public class Main {
	
	public static void main(String [] args) {
		
		
		//musicPlayer test1 = new musicPlayer();
		  
        musicPlayer player = new musicPlayer();

		  
		//  System.out.println(test1.addSong(1,"night", "artist2"));
		//  
		 // System.out.println(test1.findSong(1));
		  
		 // System.out.println(test1.showPlayList());
		  
		  //System.out.println(test1.play(1));
		 // System.out.println(test1.nowPlaying());
		 // System.out.println(test1.playCount(1));
		
		
		System.out.println(player.addSong(1, "Night Drive", "Artist 1"));
        System.out.println(player.addSong(2, "Slow Tide", "Artist 2"));
        System.out.println(player.addSong(3, "Copper Sky", "Artist 3"));
        System.out.println(player.addSong(4, "Static Bloom", "Artist 4"));
        System.out.println(player.addSong(5, "Low Orbit", "Artist 5"));
        System.out.println(player.addSong(6, "Glass Rivers", "Artist 6"));

        
        System.out.println("duplicate s3: "
                + player.addSong(3, "Another Song", "Artist 3"));

        System.out.println("playlist: " + player.showPlayList());

       

       
        System.out.println("history: " + player.showHistory());
        
        System.out.println("---2. Look Up songs ---");
       
        System.out.println("find s4: " + player.findSong(4));
        System.out.println("find s9: " + player.findSong(9));
        
        
        
        
        System.out.println("---3. Play and move forward ---");
        System.out.println("play s1: " + player.play(1));
        System.out.println("play s9: " + player.play(9));
        System.out.println("next: " + player.next());
        System.out.println("next: " + player.next()); 
        System.out.println("history: "+player.showHistory());
        
        System.out.println("---4. Up next ---");
        
        System.out.println(player.queueLater(1));
        System.out.println(player.queueLater(5));
        System.out.println(player.queueLater(6));
        
        System.out.println("queue s9"+player.queueNext(9));
        System.out.println("next" +player.next());
        System.out.println(player.nowPlaying());
        System.out.println(player.showHistory());
        
        System.out.println("---5. Back button ---");
        System.out.println("back : "+player.back());
        System.out.println("history:" +player.showHistory());
        
        System.out.println("---6. Remove songs ---");
        System.out.println("remove s5: " + player.removeSong(5));
        System.out.println("remove current (s3): " + player.removeSong(3));
        System.out.println("remove s9: " + player.removeSong(9));

        System.out.println("playlist: " + player.showPlayList());
        System.out.println("up next: " + player.showUpNext());
     
        
        System.out.println("---7. Removed songs are skipped ---");
        System.out.println("next: " + player.next());
        System.out.println("next: " + player.next());
        System.out.println("next at end: " + player.next());
        System.out.println("now playing: " + player.nowPlaying());

        System.out.println("back: " + player.back());
        System.out.println("up next: " + player.showUpNext());
        
        System.out.println(" --- 8. Play counts --- " );
        System.out.println(" s1: "+player.playCount(1) );
        System.out.println(" s3: "+player.playCount(3) );
        System.out.println(" s6: "+player.playCount(6) );
        System.out.println(" s5 (removed) "+player.playCount(5) );
        
        System.out.println("--- 9. Empty player ---");
        
        musicPlayer emptyPlayer = new musicPlayer();
        System.out.println("next: " + emptyPlayer.next());
        System.out.println("back: " + emptyPlayer.back());
        System.out.println("now playing: " + emptyPlayer.nowPlaying());
        System.out.println("playlist: " + emptyPlayer.showPlayList());
        


        
	}
	
	 

	  
}
