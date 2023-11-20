import React, { useState } from 'react';



const SSidenav = () => {
    const [isFullscreen, setFullscreen] = useState(false);

    const toggleFullscreen = () => {
        setFullscreen(!isFullscreen);
        document.documentElement.style.setProperty(
            '--screen-width',
            isFullscreen ? '100%' : '768px'
        );
        document.documentElement.style.setProperty(
            '--screen-height',
            isFullscreen ? '100%' : '1024px'
        );
        document.body.classList.toggle('mobile-style'); // Agregar o remover la clase 'mobile-style'
    };
    //togless
    const [isSubMenuOpen, setIsSubMenuOpen] = useState(false);
    const [isSubMenuAOpen, setIsSubMenuAOpen] = useState(false);
    const [isSidebarOpen, setIsSidebarOpen] = useState(true);

    const toggleSubMenu = () => {
        setIsSubMenuOpen(!isSubMenuOpen);
    };

    const toggleSubMenuA = () => {
        setIsSubMenuAOpen(!isSubMenuAOpen);
    };

    const toggleSidebar = () => {
        setIsSidebarOpen(!isSidebarOpen);
    };
    //end togless
    return (

        <div className=''>
            <span
                className="absolute text-blue text-4xl top-10 left-4 cursor-pointer ml-5"
                onClick={toggleSidebar}
            >
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
                </svg>
            </span>

            <aside className={` fixed  normal-case  bg-[#0E1B4D] text-xs  leading-normal shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]              w-60 ease-nav-brand hover:overflow-y-auto  overflow-hidden z-990  inset-y-0 my-4 ml-4 block   flex-wrap items-center justify-between  rounded-2xl border-0  p-0 antialiased xl:left-0 xl:translate-x-0 ${isSidebarOpen ? "" : "hidden"
                }`}
            >

                <div class="h-20 ">
                    <div class="block absolute px-8 py-6 m-0 text-sm whitespace-nowrap "  >

                        <svg xmlns="http://www.w3.org/2000/svg" className="w-10 h-10 text-blue-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path d="M12 14l9-5-9-5-9 5 9 5z" />
                            <path d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
                        </svg>

                    </div >
                    <button onClick={toggleSidebar} type='button' class="block xl:hidden bg-white relative px-8 py-6 m-0 text-sm whitespace-nowrap " >
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
                        </svg>
                    </button >
                </div>



                <div class="items-center block w-auto max-h-screen  md:overscroll-contain  hover:overflow-auto overflow-hidden h-sidenav grow basis-full" >
                    <ul class="flex flex-col pl-0 mb-0">

                        <li class="mt-1 w-full">
                            <a href="/dashboard" class="mt-4 hover:text-slate-300  bg-[#F82249]  pb-2 pt-2.5 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                <div class=" bg-gradient-to-r from-white hover:from-pink-500 hover:to-yellow-500 shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-white bg-center stroke-0 text-center xl:p-2">
                                    <svg fill='#F82249' role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Fortinet</title><path d="M0 9.785h6.788v4.454H0zm8.666-6.33h6.668v4.453H8.666zm0 12.637h6.668v4.454H8.666zm8.522-6.307H24v4.454h-6.812zM2.792 3.455C1.372 3.814.265 5.404 0 7.425v.506h6.788V3.454zM0 16.091v.554c.24 1.926 1.276 3.466 2.624 3.9h4.188v-4.454zm24-8.184v-.506c-.265-1.998-1.372-3.587-2.792-3.972h-4.02v4.454H24zM21.376 20.57c1.324-.458 2.36-1.974 2.624-3.9v-.554h-6.812v4.454Z" /></svg>
                                </div>
                                <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft">Dashboard</span>
                            </a>
                        </li>



                        <div onClick={toggleSubMenu}
                            class="mt-4 hover:text-slate-300  bg-[#F82249]  pb-2 pt-2.5 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                            <div class=" bg-gradient-to-r from-white  hover:from-pink-500 hover:to-yellow-500 shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-white bg-center stroke-0 text-center xl:p-2">
                                <svg fill='#F82249' role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Databricks</title><path d="M.95 14.184L12 20.403l9.919-5.55v2.21L12 22.662l-10.484-5.96-.565.308v.77L12 24l11.05-6.218v-4.317l-.515-.309L12 19.118l-9.867-5.653v-2.21L12 16.805l11.05-6.218V6.32l-.515-.308L12 11.974 2.647 6.681 12 1.388l7.76 4.368.668-.411v-.566L12 0 .95 6.27v.72L12 13.207l9.919-5.55v2.26L12 15.52 1.516 9.56l-.565.308Z" /></svg>                                            </div>
                            <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft">Tables</span>
                            <span className="text-sm rotate-180 ml-20" id="arrow">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-4 h-4">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8.25 15L12 18.75 15.75 15m-7.5-6L12 5.25 15.75 9" />
                                </svg>
                            </span>
                        </div>


                        <div
                            className={`text-left text-sm mt-2 w-4/5 ml-4 text-gray-200 font-bold ${isSubMenuOpen ? "" : "hidden"
                                }`}
                        >
                            <li class="mt-1 w-full">
                                <a href="/categoria" class="mt-4 hover:text-[#F82249]  bg-[#F82249]  pb-2 pt-2 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0  flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                    <div class="bg-gradient-to-r from-white hover:from-pink-500 hover:to-yellow-500 shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-white bg-center stroke-0 text-center xl:p-2">
                                        <svg role="img" fill='#F82249' viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Handshake</title><path d="M2.284 22.158c.001.95.679 1.752 1.62 1.792 1.31.055 2.623.022 3.935.022.954 0 1.786-.865 1.76-1.954-.029-1.221.018-2.445.029-3.667l.045-4.988c.003-.305.046-.362.335-.44a4.242 4.242 0 0 1 2.013-.067c1.23.262 2.129 1.21 2.261 2.46.066.62.07 1.249.078 1.874.025 1.64.038 3.28.054 4.921.01 1.087.796 1.877 1.883 1.882 1.171.006 2.342.008 3.513.007 1.106-.002 1.895-.778 1.898-1.883.007-3.371.007-6.742.01-10.113 0-.052 0-.105-.005-.156-.03-.355-.169-.658-.483-.838a2.638 2.638 0 0 0-.695-.291 7.484 7.484 0 0 0-2.887-.123c-.743.113-1.476.293-2.213.442-.97.196-1.946.28-2.934.178-1.268-.129-2.37-.666-3.402-1.38a32.36 32.36 0 0 0-1.494-.984c-.62-.38-1.314-.505-2.03-.544-.77-.043-1.536-.063-2.293.111-.59.136-.899.479-.966 1.077a3.438 3.438 0 0 0-.021.379m7.337-6.184a3.675 3.675 0 1 0-7.35-.031 3.675 3.675 0 0 0 7.35.03zm8.335-1.81a3.673 3.673 0 0 0-3.69 3.652 3.672 3.672 0 0 0 3.67 3.697 3.678 3.678 0 0 0 3.68-3.665 3.677 3.677 0 0 0-3.66-3.685Z" /></svg>
                                    </div>
                                    <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft">Categoria</span>
                                </a>
                            </li>

                            <li class="mt-1 w-full">
                                <a href="/producto" class="mt-4 hover:text-[#F82249]  bg-[#F82249]  pb-2 pt-2 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0  flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                    <div class="bg-gradient-to-r from-white hover:from-pink-500 hover:to-yellow-500 shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-white bg-center stroke-0 text-center xl:p-2">
                                        <svg xmlns="http://www.w3.org/2000/svg" fill='#F82249' viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                                            <path strokeLinecap="round" strokeLinejoin="round" d="M6 6.878V6a2.25 2.25 0 012.25-2.25h7.5A2.25 2.25 0 0118 6v.878m-12 0c.235-.083.487-.128.75-.128h10.5c.263 0 .515.045.75.128m-12 0A2.25 2.25 0 004.5 9v.878m13.5-3A2.25 2.25 0 0119.5 9v.878m0 0a2.246 2.246 0 00-.75-.128H5.25c-.263 0-.515.045-.75.128m15 0A2.25 2.25 0 0121 12v6a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 18v-6c0-.98.626-1.813 1.5-2.122" />
                                        </svg>

                                    </div>
                                    <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft">Productos</span>
                                </a>
                            </li>


                        </div>

                        <hr class="h-px mt-4 bg-transparent bg-gradient-to-r from-transparent via-black/40 to-transparent" />
                        {/* end toggleSubMenu */}




                        <li class="mt-1 w-full">
                            <a href="#" class="mt-4 duration-400 hover:text-[#F82249] bg-[#F82249]   pb-2 pt-2.5 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                <div class=" bg-white shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-center stroke-0 text-center xl:p-2">
                                    SVG
                                </div>
                                <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft ">Realidad Virtual</span>
                            </a>
                        </li>

                        <li class="mt-1 w-full">
                            <a href="#" class="mt-4 duration-400 hover:text-[#F82249] bg-[#F82249]   pb-2 pt-2.5 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                <div class=" bg-white shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-center stroke-0 text-center xl:p-2">
                                    SVG
                                </div>
                                <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft ">Realidad Virtual</span>
                            </a>
                        </li>
                        <li class="mt-1 w-full">
                            <a href="#" class="mt-4 duration-400 hover:text-[#F82249] bg-[#F82249]   pb-2 pt-2.5 text-xs  normal-case leading-normal shadow-[0_4px_9px_-4px_#3b71ca]  ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]  py-2 shadow-soft-xl  ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap rounded-lg hover:bg-white px-4 font-semibold text-white" >
                                <div class=" bg-white shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-center stroke-0 text-center xl:p-2">
                                    SVG
                                </div>
                                <span class="ml-1   duration-300 opacity-100 pointer-events-none ease-soft ">Realidad Virtual</span>
                            </a>
                        </li>


                        <hr class="h-px mt-4 bg-transparent bg-gradient-to-r from-transparent via-black/40 to-transparent" />

                        <li class="w-full mt-4">
                            <h6 class="pl-6 ml-2 text-xs font-bold leading-tight  normal-case opacity-60">Account pages</h6>
                        </li>

                        <li class="mt-1 w-full border-animation">
                            <a class="agg py-2  text-sm ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap px-4 transition-colors " >
                                <div class=" bg-[#F82249]  shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-gray-300 bg-center stroke-0 text-center xl:p-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill='white' height="1em" viewBox="0 0 448 512"><path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z" /></svg>
                                </div>
                                <span class="ml-1 duration-300 opacity-100 pointer-events-none ease-soft normal-case text-white">Mi Perfil</span>
                            </a>
                        </li>

                        <li class="mt-1 w-full">
                            <a href='/' class="py-2  text-sm ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap px-4 transition-colors ">
                                <div class=" bg-[#F82249]  shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-gray-300 bg-center stroke-0 text-center xl:p-2 ">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" fill='white' viewBox="0 0 512 512"><path d="M217.9 105.9L340.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L217.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1L32 320c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM352 416l64 0c17.7 0 32-14.3 32-32l0-256c0-17.7-14.3-32-32-32l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32l64 0c53 0 96 43 96 96l0 256c0 53-43 96-96 96l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32z" /></svg>

                                </div>
                                <span class="ml-1 text-sm duration-300 pointer-events-none ease-soft normal-case text-white">Sign In</span>
                            </a>
                        </li>

                        <li class="mt-1 w-full">
                            <a href='/' class="py-2  text-sm ease-nav-brand my-0 mx-4 flex items-center whitespace-nowrap px-4 transition-colors " >
                                <div class=" bg-[#F82249]  shadow-soft-2xl mr-2 flex h-8 w-8 items-center justify-center rounded-lg bg-gray-300 bg-center stroke-0 text-center xl:p-2.5">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill='white' height="1em" viewBox="0 0 640 512"><path d="M96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3zM504 312V248H440c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V136c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H552v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z" /></svg>

                                </div>
                                <span class="ml-1 duration-300 opacity-100 pointer-events-none ease-soft normal-case text-white">Sign Up</span>
                            </a>
                        </li>
                    </ul>
                </div>


            </aside>
        </div>



    );
}

export default SSidenav;