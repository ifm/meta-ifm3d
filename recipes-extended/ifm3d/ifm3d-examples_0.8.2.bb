#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


require ifm3d.inc

DEPENDS = "boost opencv pcl ifm3d-camera ifm3d-image ifm3d-framegrabber ifm3d-pcicclient"

S = "${WORKDIR}/git/modules/examples"

SRC_URI += "file://0001-ex-timestamp-replace-put_time.patch \
            file://0002-CMake-renamed-targets.patch \
"

do_fetch[depends] += "ifm3d-camera:do_fetch ifm3d-framegrabber:do_fetch \
            ifm3d-image:do_fetch ifm3d-pcicclient:do_fetch"


#---fin-----------------------------------------------------------------------
