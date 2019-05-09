package structuralPatterns.adaptor;

public class MediaAdaptor implements MediaPlayer{

	AdvancedMediaPlayer advancedMusicplayer;
	
	public MediaAdaptor(String audioType) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMusicplayer = new VlcPlayer();
		}else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMusicplayer = new Mp4Player();
		}
		
	}
	
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMusicplayer.playVlc(fileName);
		}else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMusicplayer.playMp4(fileName);
		}
	}
	
}
