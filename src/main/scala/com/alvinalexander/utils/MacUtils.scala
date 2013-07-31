package com.alvinalexander.utils

/**
 * A small collection of Mac OS X utility methods for Java and Scala applications.
 * Warning: Some of these haven't been tested yet. (I copied and pasted them from
 * old Java/Mac/Swing applications, and converted them to Scala. Sorry, no tests
 * here yet.)
 */
object MacUtils {

  /**
   * Get the user's Home directory, like '/Users/Al'
   */
  def userHomeDirectory = System.getProperty("user.home")

  /**
   * Get the user's Library directory, like '/Users/Al/Library'
   */
  def userLibDirectory = userHomeDirectory + "/Library"

  /**
   * Get the user's application support directory, like '/Users/Al/Library/Application Support'
   */
  def userApplicationSupportDirectory = userLibDirectory + "/Application Support"
  
  /**
   * Get the value of the USERNAME, like 'Al' or 'Alvin'
   */
  def username = System.getenv("USER")

  /**
   * Get the system TMPDIR value, like '/var/folders/h5/h59HESVvEmG+3I4Q8lOAxE+++TI/-Tmp-/'
   */
  def systemTmpDirectory = System.getenv("TMPDIR")

  /**
   * Returns true if running on Mac OS X, false otherwise.
   */
  def isRunningOnMacOsX = {
    val mrjVersionExists = System.getProperty("mrj.version") != null
    val osNameExists = System.getProperty("os.name").startsWith("Mac OS")
    if (mrjVersionExists && osNameExists) true else false
  }

  /**
   * Set some Mac-specific properties for Swing applications, including:
   * 
   * {{{
   * apple.awt.graphics.EnableQ2DX
   * apple.laf.useScreenMenuBar
   * com.apple.mrj.application.apple.menu.about.name
   * }}}
   * 
   * Some of these may be old; I haven't tried to write a real Mac/Java/Swing application
   * in a while.
   * 
   * @param applicationName The name of your application (like "Hyde", or "Blue Parrot")
   */
  def setMacOsXProperties(applicationName: String) {
    // set some mac-specific properties; helps when i don't use ant to build the code
    System.setProperty("apple.awt.graphics.EnableQ2DX", "true")
    System.setProperty("apple.laf.useScreenMenuBar", "true")
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", applicationName)
  }

}


