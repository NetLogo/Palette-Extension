## Using the Palette Extension

The NetLogo palette extension offers the user more control over their colors. The colors go beyond NetLogo colors, including ColorBrewer color schemes or arbitrary RGB colors. Additionally, users can control specific components of their color such as hue, alpha, and, etc.

## Getting Started

To get started with palettes add to the top of your Code tab:

```
extensions [palette]
```

you can then call any of the primitives by adding `palette:` before the primitive:

```
palette:hue-of
palette:set-saturation

palette:scale-gradient
palette:scale-scheme
```

## Background
### Review of color representation in NetLogo

Colors can be represented as NetLogo colors or RGB or RGBA colors.

*	A NetLogo color (NLC or NL color) is a number in the range 0 to 140, with the exception of 140 itself, other values are ‘wrapped'
    - NetLogo colors are shades of a base color which has unit’s digit 5, and is in the middle of the shade range
    - The color’s shade is a number in the range 0 to 10, not including 10 itself. (Not an official NetLogo concept at the moment.)
* An RGB color is a list of 3 numbers
    - The numbers represent red, green and blue and are in the range 0 to 255.
* An RGBA color is a list of 4 numbers
    - The fourth number is called alpha and is in the range 0 to 255
    - Alpha represents transparency with 0 fully transparent, and 255 full opaque
* RGB/A will be used to denote a color that is either RGB or RGBA

HSB Color Specification
Colors can also be specified (but not stored as color values) by reference to HSB - hue, saturation, brightness

* Hue ranges 0 to 360 and forms a cycle
* Saturation ranges 0 to 100
* Brightness ranges 0 to 100
* For more information, see this [guide](https://learnui.design/blog/the-hsb-color-system-practicioners-primer.html)

### More control over the color

Palette commands allow the user to directly edit a component of a color. The primitives allow for:

 * Extracting the component of a color          (example: palette:hue-of)
 * Changing the component of a color            (example: palette:with-hue)
 * Reporting the component of an agent's color  (example: palette:hue)
 * Changing the component of an agent's color   (example: palette:set-hue)

The user can also create color gradients and access ColorBrewer color schemes. All primitives are organized by colorspace or function and listed below.

### How do I choose a color scheme ?

ColorBrewer has many colors where to start. ColorBrewer has three schemes Sequential, Divergent and Qualitative. The use of ColorBrewer for maps is discussed at length in this paper (Harrower, Brewer 2003). Choosing the right colors is a design problem, thus, there are many acceptable solution. However, these guidelines might be useful for choosing colors in Agent Based Models:

* Sequential colors are best for continuous natural phenomena models such as as heat diffusion in physics or fire in earth sciences.
* Divergent colors are useful for highlighting a middle value in a model. It can be also applied to the heat diffusion model if the goal is to highlight the middle temperature.
* Qualitative colors are best for choosing colors in models where color denotes category and not value.
* For agents that cover large areas avoid strong colors and try to use pastel colors. However, for a low number of small isolated agents try to use strong colors such as such a accent.
* The main goal is to avoid having a large area covered with agents with a bright color and or having small areas having a muted pastel color.
* If you are coloring both turtles and patches, make sure they have different ranges of hue, saturation and value. E.g. Use different hues of pastel for patches and accent for turtles

### Example Models

There is an example of using the palette primitives in the Code Examples section of the models library:

* Palette Example

And one Sample Model that uses the extension:

* Heat Diffusion - Alternative Gradient

### Further Reading

* Be sure to check the [ColorBrewer web page](http://colorbrewer2.org/)
* To get a deeper understanding of how to use the color schemes read the ColorBrewer paper (Harrower, Brewer 2003)
