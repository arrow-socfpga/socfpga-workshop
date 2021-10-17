PR = "r0"
FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_my-custom-soc-board += " \
				file://devicetree/socfpga_cyclone5_my_custom_soc_board.dts \
				file://devicetree/my_custom_soc_board_ghrd.h \
				file://devicetree/my_custom_soc_board_fpga.dtsi \
				file://socfpga-5.10.60/cfg/altvipfb.cfg \
				file://socfpga-5.10.60/cfg/block.cfg \
				file://socfpga-5.10.60/cfg/cma.cfg \
				file://socfpga-5.10.60/cfg/configfs.cfg \
				file://socfpga-5.10.60/cfg/gpio-keys.cfg \
				file://socfpga-5.10.60/cfg/led-triggers.cfg \
				file://socfpga-5.10.60/cfg/net_phy.cfg \
				file://socfpga-5.10.60/cfg/usb-gadget.cfg \
				"

do_compile_prepend () {                                                            

        cp ${TOPDIR}/../meta-my-custom-soc-board/recipes-kernel/linux/config/devicetree/socfpga_cyclone5_my_custom_soc_board.dts ${S}/arch/${ARCH}/boot/dts        
        cp ${TOPDIR}/../meta-my-custom-soc-board/recipes-kernel/linux/config/devicetree/my_custom_soc_board_ghrd.h ${S}/arch/${ARCH}/boot/dts
        cp ${TOPDIR}/../meta-my-custom-soc-board/recipes-kernel/linux/config/devicetree/my_custom_soc_board_fpga.dtsi ${S}/arch/${ARCH}/boot/dts                  
}
