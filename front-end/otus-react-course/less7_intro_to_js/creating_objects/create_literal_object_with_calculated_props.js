let index = 0;

const object = {
    [['A', 'B', 'C']]: 'Some Value',
    [`prop_${index}`]: index++,
    [`prop_${index}`]: index++,
    [`prop_${index}`]: index++,
};

console.log(object);
