#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


DESCRIPTION = "Library and utilities for working with ifm pmd-based 3D ToF Cameras."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

# fa6ca78d: tag v0.8.2
SRCREV = "fa6ca78decd285370e7aeee71f06d5be35eeb0e0"

SRC_URI = "git://github.com/lovepark/ifm3d.git;protocol=https \
"

inherit cmake

EXTRA_OECMAKE += " -DCMAKE_INSTALL_PREFIX=${prefix} \
    -DIFM3D_VERSION_STRING=${PV} \
    -DIFM3D_VERSION_MAJOR=0 \
    -DIFM3D_VERSION_MINOR=8 \
    -DIFM3D_VERSION_PATCH=2 \
    -D_bin=bin \
    -D_lib=lib \
    -D_include=include \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_CXX_EXTENSIONS=OFF \
    -DCMAKE_CXX_STANDARD=11 \
    -DCMAKE_CXX_STANDARD_REQUIRED=true \
    -DBUILD_SDK_PKG=1 \
    -DCPACK_INSTALL_PREFIX=/usr \
    -DBUILD_MODULE_FRAMEGRABBER=ON \
    -DBUILD_MODULE_IMAGE=ON \
    -DBUILD_MODULE_PCICCLIENT=ON \
    -DBUILD_MODULE_TOOLS=ON \
    -DBUILD_MODULE_EXAMPLES=ON \
"

# CMake in yocto probably too old for 'CMAKE_CXX_STANDARD'
CXXFLAGS += "-std=c++11"
CFLAGS += " -std=c99"


#---fin-----------------------------------------------------------------------
