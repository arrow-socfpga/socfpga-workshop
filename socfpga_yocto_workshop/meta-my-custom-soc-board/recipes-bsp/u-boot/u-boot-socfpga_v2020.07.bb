require u-boot-socfpga-common.inc

UBOOT_VERSION = "v2020.07"

SRCREV = "68bef09e6c54e85982a94f4052b3cad603aa60c2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append_my-custom-soc-board +=	" \
					file://socfpga_my_custom_soc_board_defconfig \
					file://Kconfig \
					file://socfpga_my_custom_soc_board.h \
					file://Makefile \
					file://socfpga_cyclone5_my_custom_soc_board.dts \
					file://socfpga_cyclone5_my_custom_soc_board-u-boot.dtsi \
					file://my-custom-soc-board/MAINTAINERS \
					file://my-custom-soc-board/Makefile \
					file://my-custom-soc-board/socfpga.c \
					file://my-custom-soc-board/qts/iocsr_config.h \
					file://my-custom-soc-board/qts/pinmux_config.h \
					file://my-custom-soc-board/qts/pll_config.h \
					file://my-custom-soc-board/qts/sdram_config.h \
           				"

do_compile_prepend () {
        install -m 0644 ${THISDIR}/files/socfpga_my_custom_soc_board_defconfig ${S}/configs
        install -m 0644 ${THISDIR}/files/Kconfig ${S}/arch/arm/mach-socfpga/Kconfig
        install -m 0644 ${THISDIR}/files/socfpga_my_custom_soc_board.h ${S}/include/configs
        install -m 0644 ${THISDIR}/files/Makefile ${S}/arch/arm/dts
        install -m 0644 ${THISDIR}/files/socfpga_cyclone5_my_custom_soc_board.dts ${S}/arch/arm/dts
        install -m 0644 ${THISDIR}/files/socfpga_cyclone5_my_custom_soc_board-u-boot.dtsi ${S}/arch/arm/dts
	mkdir -p ${S}/board/custom/my-custom-soc-board/qts
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/MAINTAINERS ${S}/board/custom/my-custom-soc-board
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/Makefile ${S}/board/custom/my-custom-soc-board
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/socfpga.c ${S}/board/custom/my-custom-soc-board
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/qts/iocsr_config.h ${S}/board/custom/my-custom-soc-board/qts
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/qts/pinmux_config.h ${S}/board/custom/my-custom-soc-board/qts
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/qts/pll_config.h ${S}/board/custom/my-custom-soc-board/qts
        install -m 0644 ${THISDIR}/files/my-custom-soc-board/qts/sdram_config.h ${S}/board/custom/my-custom-soc-board/qts
}


