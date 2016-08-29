
# NetLogo Palette Extension

## Building

Use the netlogo.jar.url environment variable to tell sbt which NetLogo.jar to compile against (defaults to NetLogo 5.3). For example:

    sbt -Dnetlogo.jar.url=file:///path/to/NetLogo/target/NetLogo.jar package

If compilation succeeds, `palette.jar` will be created.

## Using the Palette Extension

The NetLogo palette extension allows to map values to colors. The colors go beyond NetLogo colors, including ColorBrewer color schemes or arbitrary RGB colors. Additionally, it provides a primitive to map to color gradients and a primitive to launch a ColorBrewer dialog for easy scheme selection.

## Getting Started

To get started with palettes add to the top of your Code tab:

```
extensions [palette]
```

you can then call any of the primitives by adding `palette:` before the primitive:

```
palette:scale-gradient
palette:scale-scheme

palette:scheme-color
palette:scheme-dialog
```

The palette extension primitives return a list containing RGB colors `[[r g b][r g b]...[r g b]]`, except for `palette:scheme-dialog` which opens a dialog.

### What colors should I use ?

ColorBrewer has many colors where to start. ColorBrewer has three schemes Sequential, Divergent and Qualitative. The use of ColorBrewer for maps is discussed at length in this paper (Harrower, Brewer 2003). Choosing the right colors is a design problem, thus, there are many acceptable solution. However, these guidelines might be useful for choosing colors in Agent Based Models:

* Sequential colors are best for continuous natural phenomena models such as as heat diffusion in physics or fire in earth sciences.
* Divergent colors are useful for highlighting a middle value in a model. It can be also applied to the heat diffusion model if the goal is to highlight the middle temperature.
* Qualitative colors are best for choosing colors in models where color denotes category and not value.
* For agents that cover large areas avoid strong colors and try to use pastel colors. However, for a low number of small isolated agents try to use strong colors such as such a accent.
* The main goal is to avoid having a large area covered with agents with a bright color and or having small areas having a muted pastel color.
* If you are coloring both turtles and patches, make sure they have different ranges of hue, saturation and value. E.g. Use different hues of pastel for patches and accent for turtles

### Should I use a continuous color gradient or just a discrete color set ?

The answer depends on the task that your will be asking from your user.

For example, gradients are more aesthetic thus are more memorable than discrete colors. Consequently, a gradient can be a better choice for presentations where the main goal of the image is to be attractive and memorable. However, binning values in a discrete set of colors simplifies tasks such as estimation and counting by removing unnecessary detail to display the big picture. Thus, discrete colors can be a better choice for a paper where the user will have the time and interest to study the visualization.

In order to see the difference you can turn on and off the gradient in the Heat Diffusion model. You can observe that turning gradient on makes the model more aesthetic, but it becomes harder to estimate the value of a patch at a given position.

### Example Models

There is an example of using the palette primitives in the Code Examples section of the models library:

* Palette Example

And one Sample Model that uses the extension:

* Heat Diffusion - Alternative Gradient

### Further Reading

* Be sure to check the [ColorBrewer web page](http://colorbrewer2.org/)
* To get a deeper understanding of how to use the color schemes read the ColorBrewer paper (Harrower, Brewer 2003)


## Primitives


### `palette:scale-gradient`

```NetLogo
palette:scale-gradient rgb-color-list number range1 range2
```


Reports an RGB color proportional to *number* using a gradient generated with *rgb-color-list*. An *rgb-color-list* consist of a list containing RGB list with three values between 0 and 255: [[r1 g1 b1] [r2 g2 b2] [r3 g3 b3] ...]

If *range1* is less than *range2*, the color will be directly mapped to gradient colors. While, if *range2* is less than *range1*, the color gradient is inverted.

If *number* is less than *range1*, then the first color of is *RGB-color-list* is chosen.

If *number* is grater than *range2*, then the last color of is *RGB-color-list* is chosen.

Example:

```
ask patches
[
  set pcolor palette:scale-gradient [[255 0 0] [0 0 255]] pxcor min-pxcor max-pxcor
]

;; colors each patch with a color proportional to the gradient
```



### `palette:scale-scheme`

```NetLogo
palette:scale-scheme scheme-type scheme-color number-of-classes range1 range2
```


Reports an RGB color proportional to *number* using the color brewer schemes. It takes six arguments the first three arguments define the ColorBrewer legend. Fir the user should select a scheme-type which can be "Sequential", "Divergent, Qualitative". Then it should select a variety of scheme-colors which depending on the scheme-color can have names such as "Reds", "Divergent", "Set1". Finally the user should select the number of classes with a minimum of 3 and a maximum between 9 and 11. For more information go to http://www.colorbrewer.org or consult the scheme-dialog primitive.

If *range1* is less than *range2*, the color will be directly mapped to scheme colors. While, if *range2* is less than *range1*, the color scheme selection is inverted.

If *number* is less than *range1*, then the first color of the resulting ColorBrewer legend is chosen.

If *number* is grater than *range2*, then the last color of the resulting ColorBrewer legend is chosen.

Example:

```
ask patches
[
  set pcolor palette:scale-scheme [[255 0 0] [0 0 255]] pxcor min-pxcor max-pxcor
]

;; colors each patch with a color from the Color Brewer Schemes
```



### `palette:scheme-colors`

```NetLogo
palette:scheme-colors scheme-type scheme-color number-of-classes
```


report a list of RGB colors with the size specified in the a number of classes

Example:

```
show palette:scheme-colors "Divergent" "Spectral" 3
=> [[252 141 89] [255 255 191] [153 213 148]]


; The schemes-color primitive can be used with the scale-gradient primitive
ask patches
  [set pcolor palette:scale-gradient palette:scheme-colors "Divergent" "Spectral" 9 pxcor min-pxcor max-pxcor]
```



### `palette:scale-gradient`

```NetLogo
palette:scale-gradient rgb-color-list number range1 range2
```


Reports an RGB color proportional to number using a gradient generated with _rgb-color-list_. An _rgb-color-list_ consist of a list containing RGB list with three values between 0 and 255: [[r1 g1 b1] [r2 g2 b2] [r3 g3 b3] ...]

If *range1* is less than *range2*, the color will be directly mapped to gradient colors. While, if *range2* is less than *range1*, the color gradient is inverted.

If *number* is less than *range1*, then the first color of is *RGB-color-list* is chosen.

If *number* is grater than *range2*, then the last color of is *RGB-color-list* is chosen.

Example:

```
ask patches
[
  set pcolor palette:scale-gradient [[255 0 0] [0 0 255]] pxcor min-pxcor max-pxcor
]

;; colors each patch with a color proportional to the gradient
```



## References

ColorBrewer http://www.colorbrewer.org

HARROWER, M. and C. BREWER (2003). ColorBrewer: An online tool for selecting color schemes for maps. The Cartographic Journal 40(1): 27-37. )

HEALEY, C G (2006) Perception in Visualization, (comprehensive review updated regularly).

HEALEY, C G, BOOTH K S, and ENNS, J T (1995). Visualizing Real-Time Multivariate Data Using Preattentive Processing ACM Transactions on Modeling and Computer Simulation 5, 3, 190-221.

TUFTE, E (1983) The Visual Display of Quantitative Information , Graphics Press.

WARE, C (2004) Information Visualization, 2nd Ed., Morgan Kaufmann.
Feedback

## Terms of Use

Copyright 1999-2015 by Uri Wilensky, Daniel Kornhauser.

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
