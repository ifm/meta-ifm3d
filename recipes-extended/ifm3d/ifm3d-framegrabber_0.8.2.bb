#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


require ifm3d.inc

DEPENDS = "boost glog ifm3d-camera"

S = "${WORKDIR}/git/modules/framegrabber"

SRC_URI += "file://0001-cmake-added-c-as-used-language-neccessary-for-yocto.patch \
            file://0002-CMake-renamed-targets_framegrabber.patch \
"

do_fetch[depends] += "ifm3d-camera:do_fetch"


#---fin-----------------------------------------------------------------------
