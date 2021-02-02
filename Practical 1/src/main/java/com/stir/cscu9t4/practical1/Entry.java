package com.stir.cscu9t4.practical1;

import java.util.Calendar;

/**
 * <p>
 *     <b><u>CSCU9T4 - Practical 1</u></b>
 *     <br />
 *     <b><u>Entry.java</u></b>
 * </p>
 * <p>
 *     This class holds information about a single training session
 * </p>
 *
 * @author Michael Sammels
 * @version 01.02.2021
 */

public class Entry {
  private final String name;
  private final Calendar dateAndTime;
  private final float distance;

  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } // Constructor

  public String getName () {
    return name;
  } // getName

  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } // getDay

  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } // getMonth

  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } // getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } // getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } // getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } // getSec

  public float getDistance () {
    return distance;
  } // getYear

  public String getEntry () {
    return getName() + " ran " + getDistance() + " km in "
            + getHour() + ":" + getMin() + ":" + getSec() + " on "
            + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
  } // getEntry
} // Entry
