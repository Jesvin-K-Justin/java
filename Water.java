
import java.util.Arrays;

interface WaterConservationSystem{
    void calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    
}

class CityBlockConservation extends RainySeasonConservation{

     @Override
     public void calculateTrappedWater(int[] blockHeights){
        int WaterStored = 0;
        int n=blockHeights.length;
        for (int i = 1; i < n-1; i++) {
            if (blockHeights[0]<blockHeights[n-1]) {
                WaterStored += Math.abs(blockHeights[0] - blockHeights[i]);
                
            }
            else{
                WaterStored += Math.abs(blockHeights[n-1] - blockHeights[i]);
            }
        }
        System.out.println("Water Stored in the city block is: "+WaterStored);
        


     }

}
public class Water {
    public static void main(String[] args) {
        int[] blockHeights1 = {3,0,0,2,0,4};
        int[] blockHeights2 = {3,0,2,0,4};
        CityBlockConservation cityBlock = new CityBlockConservation();
        System.out.println("City Blocks: "+Arrays.toString(blockHeights1));
        cityBlock.calculateTrappedWater(blockHeights1);
        System.out.println("City Blocks: "+Arrays.toString(blockHeights2));
        cityBlock.calculateTrappedWater(blockHeights2);
    }
    
}
