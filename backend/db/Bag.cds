type Id : String(4);
using Laptops from './BagInfo';
using Address from './BagInfo';

entity Bag {
    key usid : Id;
    name : String(100);

    toLaptops : association to many Laptops on toLaptops.usid = usid;
    toAddress : association to one Address on toAddress.usid = usid;
};
