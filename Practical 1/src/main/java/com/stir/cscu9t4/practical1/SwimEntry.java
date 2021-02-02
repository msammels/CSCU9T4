package com.stir.cscu9t4.practical1;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>SwimEntry.java</u></b>
 * </p>
 * <p>
 *     "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003"
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */
public class SwimEntry extends Entry {
    private final String location;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String loc) {
        super(n, d, m, y, h, min, s, dist);
        location = loc;
    } // SwimEntry

    public String getWhere() {
        if (location.equals("outdoors")) {
            return "outdoors";
        } else {
            return "in a pool";
        }
    } // getWhere

    @Override
    public String getEntry () {
        return getName() + " swam " + getDistance() + " km " + getWhere() + " in "
                + getHour() + ":" + getMin() + ":" + getSec()+ " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    } //getEntry
} // SwimEntry