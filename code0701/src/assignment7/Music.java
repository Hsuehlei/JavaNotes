package exercise.assignment7;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 19:33
 */
public class Music {

    private String musicName;
    private String playingTime;
    private String singer;

    public Music() {
    }

    public Music(String musicName, String playingTime, String singer) {
        this.musicName = musicName;
        this.playingTime = playingTime;
        this.singer = singer;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(String playingTime) {
        this.playingTime = playingTime;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }


}
