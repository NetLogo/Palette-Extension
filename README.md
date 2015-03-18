# NetLogo Palette Extension

The NetLogo Pallete Extentions allows to map values to colors. The colors go beyond NetLogo colors, including ColorBrewer color schemes or arbitrary rgb colors. Additionally, it provides a primitive to map to color gradients and a primitive to launch a ColorBrewer dialog for easy scheme selection.

## Getting Started

To get started with palettes add to the top of your procedures tab:

```
extensions [palette] 
```

you can then call any of the primitives by adding palette: before the primitive:

```
palette:scale-gradient
palette:scale-scheme

palette:scheme-color
palette:scheme-dialog
```

The palette extentions primitves return a list contaning rgb colors [[r g b][r g b]...[r g b]], except for palette:scheme-dialog which launches a dialog.

### What colors should I use ?

ColorBrewer has many colors where to start. ColorBrewer has three schemes Sequencial, Divergent and Qualitative. The use of ColorBrewer for maps is discussed at length in this paper (Harrower, Brewer 2003). Choosing the right colors is a design problem, thus, there are many acceptable solution. However, these guideines might be useful for choosing colors in Agent Based Models:

* Sequencial colors are best for continuous natural phenomena models such as as heat diffusion in physics or fire in earth sciences.
* Divergent colors are useuful for higlighting a midlle value in a model. It can be also applied to the heat diffusion model if the goal is to highlight the middle temperature.
* Qualitative colors are best for choosing colors in models where color denotes category and not value.
* For agents that cover large areas avoid strong colors and try to use pastel colors. However, for a low number of small isolated agents try to use strong colors such as such a accent.
* The main goal is to avoid having a large area covered with agents with a bright color and or having small areas having a muted pastel color.
* If you are coloring both turtles and patches, make sure they have different ranges of hue, saturation and value. E.g. Use different hues of pastel for patches and accent for turtles

### Should I use a continous color gradient or just a discrete color set ?

The answer depends on the task that your will be asking from your user.

For example, gradients are more aesthetical thus are more memorable than discrete colors. Consequently, a gradient can be a better choice for presentations where the main goal of the image is to be attractive and memorable. However, binning values in a discrete set of colors simplifies tasks such as estimation and counting by removing unnecessary detail to display the big picture. Thus, discrete colors can be a better choice for a paper where the user will have the time and interest to study the visualization.

In order to see the difference you can turn on and off the gradient in the Heat Diffusion Applet . You can observe that turning gradient on makes the model more aesthetical, but it becomes harder to estimate the value of a patch at a given position.

## Examples

### There are several examples of using the pallete primitive:

* Scale-Gradient Applet - Scale-Scheme Example.nlogo
* Scale-Gradient Applet - Scale-Gradient Example.nlogo
* Color Gradient Applet - Color Gradient Example.nlogo

### Demo Models from the NetLogo Library with scheme colors

* Heat Diffusion Applet - Heat Difussion.nlogo

## Documentation
Color mapping using NetLogo Built-in Primitives
Colors mapping using NetLogo Palette Extension

Be sure to check to ColorBrewer webpage. To get a deeper understanding of how to use the color schemes read the Colorbrewer paper (Harrower, Brewer 2003

## Palette Extension Dictionary
palette:scale-gradient
palette:scale-scheme
palette:scheme-colors
palette:scheme-dialog

## References

ColorBrewer http://www.colorbrewer.org

HARROWER, M. and C. BREWER (2003). ColorBrewer: An online tool for selecting color schemes for maps. The Cartographic Journal 40(1): 27-37. )

HEALEY, C G (2006) Perception in Visualization, (comprehensive review updated regularly).

HEALEY, C G, BOOTH K S, and ENNS, J T (1995). Visualizing Real-Time Multivariate Data Using Preattentive Processing ACM Transactions on Modeling and Computer Simulation 5, 3, 190-221.

TUFTE, E (1983) The Visual Display of Quantitative Information , Graphics Press.

WARE, C (2004) Information Visualization, 2nd Ed., Morgan Kaufmann.
Feedback

## Terms of Use

Copyright 1999-2015 by Uri Wilensky.

The MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
