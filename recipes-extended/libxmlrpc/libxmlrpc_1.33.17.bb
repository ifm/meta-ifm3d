DESCRIPTION = "XML-RPC for C/C++ is programming libraries and related tools to help you \
write an XML-RPC server or client in C or C++."
LICENSE = "BSD"
DEPENDS = "curl libxml2"
PR = "r1"
LIC_FILES_CHKSUM = "file://src/xmlrpc_client.c;beginline=1171;endline=1195;md5=d4852d10bccd98b3a5fdd46bf926bcc6"
LEAD_SONAME = "libxmlrpc.so.3"

EXTRA_OECONF = " --enable-libxml2-backend \
                 --disable-libwww-client \
                 --disable-cgi-server \
                 --disable-abyss-server \
                 --disable-cgi-server \
                 --disable-wininet-client \
"

EXTRA_OEMAKE += "AR='${AR}'"

TARGET_CC_ARCH += "${LDFLAGS}"

PARALLEL_MAKE = ""

inherit autotools binconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/xmlrpc-c/xmlrpc-c-${PV}.tgz \
           file://0001-remove-xml2-config.patch \
"

do_configure() {
	./configure ${CONFIGUREOPTS} ${EXTRA_OECONF}
}

do_install_append() {
	install -d ${D}/${bindir}
	install ${S}/xmlrpc-c-config ${D}${bindir}
}

S = "${WORKDIR}/xmlrpc-c-${PV}"
B = "${S}"

SRC_URI[md5sum] = "5c1b4514ffc8a7e0e30aeddd3bb5c83e"
SRC_URI[sha256sum] = "50118a3ca1114828f7cae27b7253cc25045849e487f5d0bb91d962777fc05355"

BBCLASSEXTEND = "native"