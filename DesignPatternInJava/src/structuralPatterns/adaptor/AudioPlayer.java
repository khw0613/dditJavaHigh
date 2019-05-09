package structuralPatterns.adaptor;

public class AudioPlayer implements MediaPlayer{

	
	MediaAdaptor mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		
		// 기본적인 음악파일 재생기능
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing Mp3 file. Name : " + fileName);
		}
		
		// MediaAdapter는 다른 포맷의 파일도 재생가능하도록 도와준다.
		else if(audioType.equalsIgnoreCase("vlc") || 
				audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdaptor(audioType);
			mediaAdapter.play(audioType, fileName);
			
		}else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
		
	}

}
