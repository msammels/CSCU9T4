package com.stir.cscu9t4.practical1;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>SprintEntry.java</u></b>
 * </p>
 * <p>
 *     "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003"
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */
public class SprintEntry extends Entry {
    private final int repetition;
    private final int recoveryMinutes;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int recMin) {
        super(n, d, m, y, h, min, s, dist);
        repetition = rep;
        recoveryMinutes = recMin;
    } // SprintEntry

    public int getRepetition() {
        return repetition;
    } // getRepetition

    public int getRecovery() {
        return recoveryMinutes;
    } // getRecovery

    @Override
    public String getEntry () {
        return getName() + " sprinted " + getRepetition() + "x" + getDistance() + "m in "
                + getHour() + ":" + getMin() + ":" + getSec() + " with " + getRecovery() + " minutes recovery on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    } //getEntry
} // SprintEntry