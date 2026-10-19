# COMP3011 Assignment 2 - Java Local Project

For more information on this code and how to get started, see https://learn.adelaide.edu.au/courses/30747/assignments/94505


# Application Files

- VideoPlayerAppLauncher, Java entry point, nothing else
- VideoPlayerApp, Second Java entry point, actually does things. takes console arguments
- CommandLineController processes the console arguments

## JavaFX Video Player
- VideoPlayerController, inside start function.
- VideoPlayerView, this is where the visual frames are processed
- VideoPlayerModel, manage data and core logic

## Frame effects
-  FrameProcessor, parent for all of the frame effects
  -  FrameBlackAndWhiter
  -  FrameBleeder
  -  FrameDuster
  -  FrameFlickerer
  -  FrameJitterer
  -  FrameMotlerer
  -  FrameNumberer
  -  FramePepperer
  -  FrameScratcher
  -  FrameVignetterr
  -  FrameYellower

# Application process
Console arguments taken with the 
