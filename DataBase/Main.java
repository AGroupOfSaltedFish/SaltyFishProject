package DataBase;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private MyDatabase myDatabase;

    Main() {
        myDatabase = new MyDatabase();
    }

    public void initDatabase() {
        myDatabase.initTable();
    }

    public void insertUser(Integer userId, String userName, String userPassword) {
        myDatabase.insertUser(userId, userName, userPassword);
    }

    public void insertClothes(Integer userId, Clothes clothes) {
        myDatabase.insertClothes(userId, clothes);
    }

    public void deleteUser(Integer userId) {
        myDatabase.deleteUser(userId);
    }

    public void insertHistory(Integer userId, Suit suit, Weather weather) {
        myDatabase.insertHistory(userId, suit, weather);
    }

    public UserInfo getUserInfoById(Integer userId) {
        return myDatabase.getUserInfoById(userId);
    }

    public static void main(String[] args) {

        Main userMain = new Main();
        userMain.initDatabase();

        ClothesInfo u_clothesInfo = new ClothesInfo();
        UserInfo userInfo = new UserInfo(123, "cjh", "123456", u_clothesInfo);
        userMain.insertUser(userInfo.getId(), userInfo.getName(), userInfo.getPassword());

        //userMain.deleteUser(userInfo);

        Clothes clothes = new Clothes(1, 2, 3, 4, 5);
        userMain.insertClothes(userInfo.getId(), clothes);
        Clothes clothes2 = new Clothes(2, 2, 4, 5, 6);
        userMain.insertClothes(userInfo.getId(), clothes2);

        List<Integer> clothesIdList = new ArrayList<>();
        List<Integer> clothesIdList2 = new ArrayList<>();
        clothesIdList.add(clothes2.getClothesId());
        clothesIdList.add(clothes.getClothesId());
        clothesIdList2.add(clothes.getClothesId());
        Suit suit = new Suit(clothesIdList);
        Suit suit2 = new Suit(clothesIdList2);
        Weather weather = Weather.SUNNY;
        Weather weather2 = Weather.RAINY;
        for(int i = 0; i < 30;i++)
            userMain.insertHistory(userInfo.getId(), suit, weather);
        userMain.insertHistory(userInfo.getId(), suit2, weather2);

        UserInfo userInfo1 = userMain.getUserInfoById(123);
    }

}
