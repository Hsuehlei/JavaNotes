package exercise.assignment7;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 19:44
 */
public class Test {

    public static void main(String[] args) {

        Music m = new Music();
        MusicPlayer mp = new MusicPlayer();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入音乐名：");
        String musicName = sc.next();
        m.setMusicName(musicName);
        System.out.print("请输入播放时长：");
        String playingTime = sc.next();
        m.setPlayingTime(playingTime);
        System.out.print("请输入歌手名：");
        String singer = sc.next();
        m.setSinger(singer);

        mp.playMusic(m);
    }
}
