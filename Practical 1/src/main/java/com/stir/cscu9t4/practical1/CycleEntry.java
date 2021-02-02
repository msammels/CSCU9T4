package com.stir.cscu9t4.practical1;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>CycleEntry.java</u></b>
 * </p>
 * <p>
 *     "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate speed"
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */

public class CycleEntry extends Entry {
    private final String terrain;
    private final String tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String trn, String spd) {
        super(n, d, m, y, h, min, s, dist);
        terrain = trn;
        tempo = spd;
    } // CycleEntry

    public String getTerrain() {
        return terrain;
    } // getTerrain

    public String getTempo() {
        return tempo;
    } // getSpeed

    @Override
    public String getEntry () {
        return getName()+ " cycled " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + " on "
                +getTerrain() + " at "+ getTempo() + " speed\n";
    } //getEntry
} // CycleEntry