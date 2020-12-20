inherit core-image

IMAGE_INSTALL += " \
	u-boot-socfpga \
	my-custom-soc-board-rbf \
	bash \
	ethtool \
	gcc \
	gdb \
	gdbserver \
	i2c-tools \
	iw \
	kernel-dev \
	kernel-image \
	kernel-modules \
	net-tools \
	nfs-utils-client \
	openssh \
	python \
	tar \
	usbutils \
	vim \
	vim-vimrc \
"

export IMAGE_BASENAME = "console-image"

IMAGE_FEATURES += "package-management"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp

