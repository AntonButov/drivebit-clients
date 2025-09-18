#!/usr/bin/env python3
"""
Script to generate PNG icons from SVG files using cairosvg
"""

import cairosvg
import os
import sys

def generate_png_from_svg(svg_path, output_path, width=None, height=None):
    """Generate PNG from SVG file"""
    try:
        # Read SVG content
        with open(svg_path, 'r', encoding='utf-8') as f:
            svg_content = f.read()
        
        # Generate PNG
        if width and height:
            png_data = cairosvg.svg2png(bytestring=svg_content.encode('utf-8'), 
                                      output_width=width, 
                                      output_height=height)
        else:
            png_data = cairosvg.svg2png(bytestring=svg_content.encode('utf-8'))
        
        # Write PNG file
        with open(output_path, 'wb') as f:
            f.write(png_data)
        
        print(f"Successfully generated {output_path}")
        return True
        
    except Exception as e:
        print(f"Error generating PNG: {e}")
        return False

def main():
    if len(sys.argv) < 3:
        print("Usage: python3 generate_png.py <svg_file> <output_png> [width] [height]")
        sys.exit(1)
    
    svg_file = sys.argv[1]
    output_png = sys.argv[2]
    width = int(sys.argv[3]) if len(sys.argv) > 3 else None
    height = int(sys.argv[4]) if len(sys.argv) > 4 else None
    
    if not os.path.exists(svg_file):
        print(f"SVG file not found: {svg_file}")
        sys.exit(1)
    
    success = generate_png_from_svg(svg_file, output_png, width, height)
    sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()
