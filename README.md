# COMP3011 Assignment 2 - Java Local Project
This is a simple Video Player that starts through the command line controls. It also comes with a series of frames and effects that can be run over the videos

For more information on this code and how to get started, see https://learn.adelaide.edu.au/courses/30747/assignments/94505

# Command line controls

```
Usage: VideoPlayer [options] [video-file]

Options:
  -h, --help         Show this help message
  -a, --audio        Play audio
  -x, --maximise     Open the player maximised
  -1, --monitor-1    Open the player on display 1
  -2, --monitor-2    Open the player on display 2
  
Frame processors:
  -n, --number-frames    Render the frame number onto each frame
  -s, --scratch-frames   Render vertical film scratches
  -f, --flicker-frames   Randomly dim frames
  -w, --black-and-white  Convert frames to black and white
  -y, --yellow-frames    Apply a warmer colour temperature
  -v, --vignette-frames  Darken the frame edges
  -d, --dust-frames      Render dust and hair marks
  -j, --jitter-frames    Randomly displace frames by a few pixels
  -m, --mottle-frames    Add cloudy emulsion mottling
  -b, --bleed-frames     Bleed light into frames
  -p, --pepper-frames    Pepper frames with dark spots/blotches
```

# Application Files

- VideoPlayerAppLauncher, Java entry point, nothing else
- VideoPlayerApp, Second Java entry point, actually does things. takes console arguments
- CommandLineController processes the console arguments

## JavaFX Video Player
- VideoPlayerController, inside start function.
- VideoPlayerView, this is where the visual frames are processed
- VideoPlayerModel, manage data and core logic

## Frame effects
-  FrameProcessor, parent file for the frame effects
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
