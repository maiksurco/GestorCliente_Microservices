import React from "react";

const Modal = ({ isOpen, onClose, children }) => {
    if (!isOpen) return null;
  return (
        <div className="fixed left-0 top-0 z-[1055] w-full h-full bg-gray-800 bg-opacity-50 flex items-center justify-center">
          <div className="bg-white shadow-lg w-[500px] p-1 rounded">
            {/* Contenido del modal */}
            {children}
          </div>
        </div>
  );
};

export default Modal;
