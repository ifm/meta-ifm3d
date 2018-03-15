#-----------------------------------------------------------------------------
#
# \brief    Yocto recipe for ifm3d
#
#-----------------------------------------------------------------------------


require ifm3d.inc

DEPENDS = "boost glog libxmlrpc"

SRC_URI += "file://0001-camera-fixed-constructor-list-for-gcc-4.9.patch \
"

S = "${WORKDIR}/git/modules/camera"

BBCLASSEXTEND += "native"


#---fin-----------------------------------------------------------------------
