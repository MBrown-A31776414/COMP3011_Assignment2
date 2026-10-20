/*
 * Starter code supplied for Adelaide University COMP3011 Assignment 2.
 * Students are free to modify this file for assessment purposes.
 * 
 * Authors:
 *   1. Simon Ratcliffe, in collaboration with GPT-5.6 Terra
 *   2. <student name and student number insert here upon modification>
 *
 * Copyright 2026 Simon Ratcliffe
 */
package comp3011;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created in the VideoPlayerApp's main function to receive and parse the video player's command-line arguments.
 *
 * <p>
 * Extracts the video file and supported launch options, reports invalid input
 * or help text, and exposes the resulting launch configuration via methods to the
 * {@link VideoPlayerApp}.
 * </p>
 */
public class CommandLineController {
    
	// list of input arguments
	private final String[] args;

    // 
    private boolean helpRequested;
    private boolean audioRequested;
    private boolean maximiseRequested;
    
    // details of the
    private Integer displayId;
    private File videoFile;
    private String errorMessage;
    
    // Specification 1 setting on or off
    private boolean numberFrames;
    private boolean scratchFrames;
    private boolean flickerFrames;
    private boolean blackAndWhite;
    private boolean yellowFrames;
    private boolean vignetteFrames;
    private boolean dustFrames;
    private boolean jitterFrames;
    private boolean mottleFrames;
    private boolean bleedFrames;
    private boolean pepperFrames;
    
    // On creation parse the argument or 
    public CommandLineController(String[] args) {
    	// Clone input arguments to class variable and parse the arguments
        this.args = args.clone();
        
        parse();
        if (errorMessage != null) {
            System.out.println(errorMessage);
        }
        if (helpRequested) {
            printHelp();
        }
    }

    // 
    public File getVideoFile() {
        return videoFile;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getExitCode() {
        return errorMessage == null ? 0 : 1;
    }

    public Integer getDisplayId() {
        return displayId;
    }

    public boolean isAudioRequested() {
        return audioRequested;
    }

    public boolean isMaximiseRequested() {
        return maximiseRequested;
    }

    public boolean shouldLaunchApplication() {
        return errorMessage == null && videoFile != null;
    }
    
    /**
     * Specification 1; frame processors
     */
    public boolean getNumberFrames() {
    	return numberFrames;
    }
    public boolean getScratchFrames() {
    	return scratchFrames;
    }
    public boolean getFlickerFrames() {
    	return flickerFrames;
    }
    public boolean getBlackAndWhiteFrames() {
    	return blackAndWhite;
    }
    public boolean getYellowFrames() {
    	return yellowFrames;
    }
    public boolean getVignetteFrames() {
    	return vignetteFrames;
    }
    public boolean getDustFrames() {
    	return dustFrames;
    }
    public boolean getJitterFrames() {
    	return jitterFrames;
    }
    public boolean getMottleFrames() {
    	return mottleFrames;
    }
    public boolean getBleedFrames() {
    	return bleedFrames;
    }
    public boolean getPepperFrames() {
    	return pepperFrames;
    }

    private void parse() {
        List<String> videoFiles = new ArrayList<>();
        for (String arg : args) {
        	//arg = arg.toLowerCase();
            if ("-h".equals(arg) || "--help".equals(arg)) {
                helpRequested = true;
            } else if ("-a".equals(arg) || "--audio".equals(arg)) {
                audioRequested = true;
            } else if ("-x".equals(arg) || "--maximise".equals(arg)) {
                maximiseRequested = true;
            } else if ("-1".equals(arg) || "--monitor-1".equals(arg)) {
                setDisplayId(1);
            } else if ("-2".equals(arg) || "--monitor-2".equals(arg)) {
                setDisplayId(2);
                
            // specification 1 arguments, if argument in terminal set true
            // base character and extended description
            } else if ("-n".equals(arg) || "--number-frames".equals(arg)) {
                numberFrames = true;
            } else if ("-s".equals(arg) || "--scratch-frames".equals(arg)) {
                scratchFrames = true;
            } else if ("-f".equals(arg) || "--flicker-frame".equals(arg)) {
                flickerFrames = true;
            } else if ("-w".equals(arg) || "--black-and-white".equals(arg)) {
                blackAndWhite = true;
            } else if ("-y".equals(arg) || "--yellow-frames".equals(arg)) {
            	yellowFrames = true;
            } else if ("-v".equals(arg) || "--vignette-frames".equals(arg)) {
            	vignetteFrames = true;
            } else if ("-d".equals(arg) || "--dust-frames".equals(arg)) {
            	dustFrames = true;
            } else if ("-j".equals(arg) || "--jitter-frames".equals(arg)) {
            	jitterFrames = true;
            } else if ("-m".equals(arg) || "--mottle-frames".equals(arg)) {
            	mottleFrames = true;
            } else if ("-b".equals(arg) || "--bleed-frames".equals(arg)) {
            	bleedFrames = true;
            } else if ("-p".equals(arg) || "--pepper-frames".equals(arg)) {
            	pepperFrames = true;
            // if an argument has multiple characters
            } else if (arg.startsWith("-")&&(arg.length()>1)) {
            	for(int i =0; i <arg.length(); i++) {
            		if('n' == arg.charAt(i)) {
            			numberFrames = true;
            		}
            		else if('s' == arg.charAt(i)) {
            			scratchFrames = true;
            		}
            		else if('f' == arg.charAt(i)) {
            			flickerFrames = true;
            		}
            		else if('w' == arg.charAt(i)) {
            			blackAndWhite = true;
            		}
            		else if('y' == arg.charAt(i)) {
            			yellowFrames = true;
            		}
            		else if('v' == arg.charAt(i)) {
            			vignetteFrames = true;
            		}
            		else if('d' == arg.charAt(i)) {
            			dustFrames = true;
            		}
            		else if('j' == arg.charAt(i)) {
            			jitterFrames = true;
            		}
            		else if('m' == arg.charAt(i)) {
            			mottleFrames = true;
            		}
            		else if('b' == arg.charAt(i)) {
            			bleedFrames = true;
            		}
            		else if('p' == arg.charAt(i)) {
            			pepperFrames = true;
            		}
            		else {
            			System.out.println("strange error");
            			//errorMessage = "Unknown option: " + arg.charAt(i); 
            		}
            	}
            } else if (arg.startsWith("-")) {
                errorMessage = "Unknown option: " + arg;
            } else {
                videoFiles.add(arg);
            }
        }

        if (videoFiles.size() > 1) {
            errorMessage = "Usage: VideoPlayer [options] [video-file]";
        } else if (videoFiles.size() == 1) {
            videoFile = new File(videoFiles.get(0));
            if (!videoFile.isFile()) {
                errorMessage = "File not found: " + videoFile.getPath();
                videoFile = null;
            }
        } else {
            if (!helpRequested) {
                errorMessage = "No video file specified.";
            }
        }
    }

    private void setDisplayId(int displayId) {
        if (this.displayId != null && this.displayId != displayId) {
            errorMessage = "Only one display option can be used";
            return;
        }
        this.displayId = displayId;
    }

    // Help message to print to console, needs to be extremely precise for tool upload to accept
    private void printHelp() {
        System.out.println("Usage: VideoPlayer [options] [video-file]");
        System.out.println();
        System.out.println("Options:");
        System.out.println("  -h, --help         Show this help message");
        System.out.println("  -a, --audio        Play audio");
        System.out.println("  -x, --maximise     Open the player maximised");
        System.out.println("  -1, --monitor-1    Open the player on display 1");
        System.out.println("  -2, --monitor-2    Open the player on display 2");
        System.out.println();
        // Specification 1, extended help
        System.out.println("Frame processors:");
        System.out.println("  -n, --number-frames    Render the frame number onto each frame");
        System.out.println("  -s, --scratch-frames   Render vertical film scratches");
        System.out.println("  -f, --flicker-frames   Randomly dim frames");
        System.out.println("  -w, --black-and-white  Convert frames to black and white");
        System.out.println("  -y, --yellow-frames    Apply a warmer colour temperature");
        System.out.println("  -v, --vignette-frames  Darken the frame edges");
        System.out.println("  -d, --dust-frames      Render dust and hair marks");
        System.out.println("  -j, --jitter-frames    Randomly displace frames by a few pixels");
        System.out.println("  -m, --mottle-frames    Add cloudy emulsion mottling");
        System.out.println("  -b, --bleed-frames     Bleed light into frames");
        System.out.println("  -p, --pepper-frames    Pepper frames with dark spots/blotches");
        System.out.println();
        System.out.println("Frame processors are applied in command-line order and may be repeated.");
        System.out.println("Example: -nssnfwyvdjmbp numbers, scratches twice, numbers again, flickers,");
        System.out.println("converts, warms, vignettes, dusts, jitters, mottles, bleeds, then peppers.");
    }
}
