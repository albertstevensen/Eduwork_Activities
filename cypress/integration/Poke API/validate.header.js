describe('Validate Header', () =>{
    it.only('Assertion Body', () => {
        cy.request('https://pokeapi.co/api/v2/pokemon/ditto').as('pokemon').should((response) => {
            expect(response.status).to.eq(200)
            expect(response.body.abilities[0].ability.name).to.not.be.null
            expect(response.body.abilities[1].ability.name).to.not.be.null
            expect(response.body.abilities[0].ability.url).to.not.be.null
            expect(response.body.abilities[1].ability.url).to.not.be.null

            expect(response.body.game_indices).to.not.be.null
          });
    });
});