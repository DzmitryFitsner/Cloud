//MOCK service
module.exports = (srv) => {

    srv.on('READ', 'Bags', () => [
        {
            usid: 'U001', name: "Canon",
            toLaptops: [
                {crid: "C001", usid: "U001", name: "Lenovo ThinkPad T490", toBag: {usid: 'U001', name: "Canonnn"}}
            ],
            toAddress: [
                { adid: "A001", usid: "U001", city: "Stolin", strt: "Klenovaia" }
            ]
        }
    ]);

    srv.on('READ', 'Address', () => [
        { adid: "A001", usid: "U001", city: "Stolin", strt: "Klenovaia" }
    ]);

    srv.on('READ', 'Laptops', () => [
        {crid: "C001", usid: "U001", name: "Lenovo ThinkPad T490", toBag: {usid: 'U001', name: "Canonn"}}
    ]);

};
