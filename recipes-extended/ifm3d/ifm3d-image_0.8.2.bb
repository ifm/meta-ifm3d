#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


require ifm3d.inc

DEPENDS = "boost glog opencv pcl ifm3d-framegrabber"

S = "${WORKDIR}/git/modules/image"

SRC_URI += "file://0002-CMake-renamed-targets_image.patch \
"

do_fetch[depends] += "ifm3d-camera:do_fetch"

EXTRA_OECMAKE += " -DFORCE_OPENCV2=OFF"


#---fin-----------------------------------------------------------------------
