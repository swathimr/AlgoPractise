package OODesign.ParkingLot;

public class Spot {
    long id;
    int level;
    size size;

    Spot(long id, int level, size size) {
        this.id = id;
        this.level = level;
        this.size = size;
    }
}
