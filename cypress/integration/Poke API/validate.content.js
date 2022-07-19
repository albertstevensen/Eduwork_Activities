describe('Validate Content', () =>{

    it('Validate Content', () =>{
        cy.request('https://pokeapi.co/api/v2/pokemon/ditto').as('pokemon').should((response) => {
            //Berikut adalah jawaban untuk melengkapi code yang kurang
            expect(response.body.abilities[0].ability.name).to.eq("limber")
        })
        
    })
});