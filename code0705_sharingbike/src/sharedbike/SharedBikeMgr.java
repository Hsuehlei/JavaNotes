package sharedbike;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/4 19:06
 */
public class SharedBikeMgr {

    /**
     * 初始化三个公司，以及每个公司单车基本信息
     */
    public SharedBikeCompany[] initial() {

        SharedBike[] ofo = new SharedBike[3];
        SharedBike ofo1 = new SharedBike(1, "ofo单车0", 1, "");
        SharedBike ofo2 = new SharedBike(2, "ofo单车1", 1, "");
        SharedBike ofo3 = new SharedBike(3, "ofo单车2", 1, "");
        ofo[0] = ofo1;
        ofo[1] = ofo2;
        ofo[2] = ofo3;

        SharedBike[] halo = new SharedBike[3];
        SharedBike halo1 = new SharedBike(1, "halo单车0", 1, "");
        SharedBike halo2 = new SharedBike(2, "halo单车1", 1, "");
        SharedBike halo3 = new SharedBike(3, "halo单车2", 1, "");
        halo[0] = halo1;
        halo[1] = halo2;
        halo[2] = halo3;

        SharedBike[] mobike = new SharedBike[3];
        SharedBike mobike1 = new SharedBike(1, "MoBike单车0", 1, "");
        SharedBike mobike2 = new SharedBike(2, "MoBike单车1", 1, "");
        SharedBike mobike3 = new SharedBike(3, "MoBike单车2", 1, "");
        mobike[0] = mobike1;
        mobike[1] = mobike2;
        mobike[2] = mobike3;


        SharedBikeCompany[] bikeCompanies = new SharedBikeCompany[3];
        SharedBikeCompany sbc1 = new SharedBikeCompany(1, "ofo单车", ofo, 3,100);
        SharedBikeCompany sbc2 = new SharedBikeCompany(2, "halo单车", halo, 3,210);
        SharedBikeCompany sbc3 = new SharedBikeCompany(3, "摩拜单车", mobike, 3,50);
        bikeCompanies[0] = sbc1;
        bikeCompanies[1] = sbc2;
        bikeCompanies[2] = sbc3;

        return bikeCompanies;
    }
}
