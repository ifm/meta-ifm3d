#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


require ifm3d.inc

DEPENDS = "pcl opencv glog boost curl ifm3d-camera ifm3d-framegrabber ifm3d-image"

S = "${WORKDIR}/git/modules/tools"

SRC_URI += "file://0002-CMake-renamed-targets_tools.patch \
"

do_fetch[depends] += "ifm3d-camera:do_fetch ifm3d-framegrabber:do_fetch ifm3d-image:do_fetch"

# BUILD_MODULE_IMAGE would cause using pcl_visualization which depends on VTK
EXTRA_OECMAKE += "-DBUILD_MODULE_IMAGE=OFF"


#---fin-----------------------------------------------------------------------
