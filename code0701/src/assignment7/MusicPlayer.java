package exercise.assignment7;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 19:36
 */
public class MusicPlayer {

    private String mpName;

    public MusicPlayer() {
    }

    public MusicPlayer(String mpName) {
        this.mpName = mpName;
    }

    public String getMpName() {
        return mpName;
    }

    public void setMpName(String mpName) {
        this.mpName = mpName;
    }

    public Music playMusic(Music m) {
        System.out.println("正在播放" + m.getSinger() + "歌唱的音乐[" + m.getMusicName() + "]，剩余时间" +m.getPlayingTime());
        return m;
    }
}
