package sharedbike_v2;


import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/6 19:59
 */
public class InitialStart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShareBikeMgr shareBikeManagerSystem = new ShareBikeMgr();
        ShareBikeCompany[] shareBikeCompanies = new ShareBikeCompany[3];

        ShareBike[] haloBikes = new ShareBike[3];
        ShareBike[] moBikes = new ShareBike[3];
        ShareBike[] ofoBikes = new ShareBike[3];

        ShareBike halo1 = new ShareBike(1, "halo1", 1, "");
        ShareBike halo2 = new ShareBike(2, "halo2", 1, "");
        ShareBike halo3 = new ShareBike(3, "halo3", 1, "");
        haloBikes[0] = halo1;
        haloBikes[1] = halo2;
        haloBikes[2] = halo3;

        ShareBike moBike1 = new ShareBike(1, "moBike1", 1, "");
        ShareBike moBike2 = new ShareBike(2, "moBike2", 1, "");
        ShareBike moBike3 = new ShareBike(3, "moBike3", 1, "");
        moBikes[0] = moBike1;
        moBikes[1] = moBike2;
        moBikes[2] = moBike3;

        ShareBike ofo1 = new ShareBike(1,"ofo1",1,"");
        ShareBike ofo2 = new ShareBike(2,"ofo2",1,"");
        ShareBike ofo3 = new ShareBike(3,"ofo3",1,"");
        ofoBikes[0] = ofo1;
        ofoBikes[1] = ofo2;
        ofoBikes[2] = ofo3;

        ShareBikeCompany halo = new ShareBikeCompany(1, "halo", haloBikes, 3, 210);
        ShareBikeCompany moBike = new ShareBikeCompany(2, "moBike", moBikes, 3, 50);
        ShareBikeCompany ofo = new ShareBikeCompany(3, "ofo", ofoBikes, 3, 103);
        shareBikeCompanies[0] = halo;
        shareBikeCompanies[1] = moBike;
        shareBikeCompanies[2] = ofo;


        shareBikeManagerSystem.userSelect(sc, shareBikeCompanies);
    }

}
