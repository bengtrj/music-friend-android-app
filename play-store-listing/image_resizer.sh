#!/usr/bin/env bash

set -ex

imageFolder="en_us/screenshots/"
width=600
height=1200

find "${imageFolder}" -iname '*.png' -exec convert \{} -verbose -resize "${width}x${height}" -background white -gravity center -extent "${width}x${height}"\> \{} \;
