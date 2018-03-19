#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d-ros
#
#-----------------------------------------------------------------------------


DESCRIPTION = "ifm pmd-based 3D ToF Camera ROS Package"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

# 4a158bf: tag v0.4.1
SRCREV = "4a158bf7949c515c73757e567db1811ab2ccd5fd"

SRC_URI = "git://github.com/lovepark/ifm3d.git;protocol=https \
"


EXTRA_OECMAKE += " -DCMAKE_INSTALL_PREFIX=${prefix} \
"

# CMake in yocto probably too old for 'CMAKE_CXX_STANDARD'
CXXFLAGS += "-std=c++11"
CFLAGS += " -std=c99"


DEPENDS = " ifm3d-camera \
            ifm3d-framegrabber \
            ifm3d-image \
            boost \
            image-transport \
            pcl-ros \
            cv-bridge \
            roscpp \
            sensor-msgs \
            std-msgs \
            tf \
            message-generation \
"

SRC_URI += ""

S = "${WORKDIR}/git"

inherit catkin cmake


#---fin-----------------------------------------------------------------------
